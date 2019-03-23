package cn.young.manager.web.controller;

import cn.young.manager.pojo.CourseSelected;
import cn.young.manager.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

public class RecommendController {




    @RequestMapping("/recommend")
    public ModelAndView recommend(HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("loginUser");

        this.uname=user.getUname();
        CourseSelected[] CS=CSservice.getInfo();

        for(int i=0;i<CS.length;i++){
            System.out.println(CS[i].getCourse_code()+CS[i].getUname()+CS[i].getMark());
        }
        System.out.println();
        Map<String, Map<String, Integer>> userPerfMap = new HashMap<String, Map<String, Integer>>();
        Map<String, Map<String, Integer>> currentUser = new HashMap<String, Map<String, Integer>>();

        Map<String, Integer> pref1 = new HashMap<String, Integer>();
        Map<String,Integer>[] persons = new Map[CS.length];
        persons[0] = new HashMap();
        persons[0].put(CS[0].getCourse_code(),CS[0].getMark());
        userPerfMap.put(CS[0].getUname(),persons[0]);
        int coun=1;
        for(int i=1;i<CS.length;i++){
            persons[i] = new HashMap();
            for(int j=coun;j<CS.length;j++){
                persons[i].put(CS[j].getCourse_code(),CS[j].getMark());
                System.out.println(CS[j].getUname()+"===="+CS[j-1].getUname()+"   "+i+"=="+j);
                if(((CS[j].getUname()).equals(CS[j-1].getUname()))){

                    System.out.println("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");

                }else{
                    Map<String, Integer> a =userPerfMap.put(CS[j].getUname(),persons[i]);
                    coun=j;
                    System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"+a+userPerfMap.size()+userPerfMap.entrySet());

                }
            }
        }
        Map<String, Double> simUserSimMap = new HashMap<String, Double>();
        System.out.println("皮尔逊相关系数:"+uname);

        for(Entry<String,Map<String,Integer>> userperEn:userPerfMap.entrySet()){
            String username=userperEn.getKey();
            System.out.println(username+userperEn.getValue().size());
            if(!"uname".equals(username)){
                double sim = getUserSimilar(userperEn.getValue(), userperEn.getValue());
                System.out.println(uname+"与" + username + "之间的相关系数:" + sim);
                simUserSimMap.put(username, sim);
            }
        }
        Map<String, Map<String, Integer>> simUserObjMap = new HashMap<String, Map<String, Integer>>();
        Map<String, Integer> pobjMap1 = new HashMap<String, Integer>();

        for(Entry<String,Map<String,Integer>> p:userPerfMap.entrySet()){

            simUserObjMap.put(p.getKey(), p.getValue());

        }

        System.out.println("推荐结果:" + getRecommend(simUserObjMap, simUserSimMap));
        ModelAndView mv=new ModelAndView();
        Course c=new Course();
        c.setCourse_code(getRecommend(simUserObjMap, simUserSimMap));
        Course courseName=CSservice.selectCourseName(c);
        mv.addObject("personnal",courseName.getCourse_name());
        //mv.addObject("personnal",getRecommend(simUserObjMap, simUserSimMap));
        mv.setViewName("recommend.jsp");
        return mv;
    }
    //Claculate Pearson Correlation Coefficient
    public static double getUserSimilar(Map<String, Integer> pm1, Map<String, Integer> pm2) {
        int n = 0;// 数量n
        int sxy = 0;// Σxy=x1*y1+x2*y2+....xn*yn
        int sx = 0;// Σx=x1+x2+....xn
        int sy = 0;// Σy=y1+y2+...yn
        int sx2 = 0;// Σx2=(x1)2+(x2)2+....(xn)2
        int sy2 = 0;// Σy2=(y1)2+(y2)2+....(yn)2
        for (Map.Entry<String, Integer> pme : pm1.entrySet()) {
            String key = pme.getKey();
            Integer x = pme.getValue();
            Integer y = pm2.get(key);
            if (x != null && y != null) {
                n++;
                sxy += x * y;
                sx += x;
                sy += y;
                sx2 += Math.pow(x, 2);
                sy2 += Math.pow(y, 2);
            }
        }
        // p=(Σxy-Σx*Σy/n)/Math.sqrt((Σx2-(Σx)2/n)(Σy2-(Σy)2/n));
        double sd = sxy - sx * sy / n;
        double sm = Math.sqrt((sx2 - Math.pow(sx, 2) / n) * (sy2 - Math.pow(sy, 2) / n));
        return Math.abs(sm == 0 ? 1 : sd / sm);
    }

    //获取推荐结果
    public static String getRecommend(Map<String, Map<String, Integer>> simUserObjMap,
                                      Map<String, Double> simUserSimMap) {
        Map<String, Double> objScoreMap = new HashMap<String, Double>();
        for (Map.Entry<String, Map<String, Integer>> simUserEn : simUserObjMap.entrySet()) {
            String user = simUserEn.getKey();
            double sim = simUserSimMap.get(user);
            for (Map.Entry<String, Integer> simObjEn : simUserEn.getValue().entrySet()) {
                double objScore = sim * simObjEn.getValue();//加权（相似度*评分）
                String objName = simObjEn.getKey();
                if (objScoreMap.get(objName) == null) {
                    objScoreMap.put(objName, objScore);
                } else {
                    double totalScore = objScoreMap.get(objName);
                    objScoreMap.put(objName, totalScore + objScore);//将所有用户的加权评分作为最后的推荐结果数据
                }
            }
        }
        List<Map.Entry<String, Double>> enList = new ArrayList<Map.Entry<String, Double>>(objScoreMap.entrySet());
        Collections.sort(enList, new Comparator<Map.Entry<String, Double>>() {//排序
            public int compare(Map.Entry<String, Double> o1, Map.Entry<String, Double> o2) {
                Double a = o1.getValue() - o2.getValue();
                if (a == 0) {
                    return 0;
                } else if (a > 0) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
        for (Map.Entry<String, Double> entry : enList) {
            System.out.println(entry.getKey()+"的加权推荐值:"+entry.getValue());
        }
        return enList.get(enList.size() - 1).getKey();//返回推荐结果
    }

}
