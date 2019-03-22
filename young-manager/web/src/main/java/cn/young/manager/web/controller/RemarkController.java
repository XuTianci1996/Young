package cn.young.manager.web.controller;

import cn.young.manager.pojo.*;
import cn.young.manager.service.CourseSelectedService;
import cn.young.manager.service.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class RemarkController {
    @Autowired
    private CourseSelectedService courseSelectedService;

    @Autowired
    private EvaluationService evaluationService;

    /**
     * 跳转到我的评价列表页
     *
     * @param request
     * @return
     */
    @RequestMapping("/myremark")
    public String myRemarkInfo(HttpServletRequest request) {
        HttpSession session = request.getSession();
        User loginUser = (User) session.getAttribute("loginUser");
        if (loginUser != null) {
            return "myremark";
        } else {
            return "redirect:index";
        }
    }

    /**
     * 我的评价列表
     *
     * @param page
     * @param limit
     * @param request
     * @return
     */
    @RequestMapping("/myRemarkInfo")
    @ResponseBody
    public PagingData<MyRemark> getMyRemarkByUid(int page, int limit, HttpServletRequest request) {
//        System.out.println("评价页："+page);
//        System.out.println("每页条数："+limit);
        User user = (User) request.getSession().getAttribute("loginUser");
        // 设置uid
        long uidLong = user.getUid();
        return courseSelectedService.getMyRemarkByUid((int) uidLong, page, limit);
    }

    /**
     * 跳转到某个课程的评价页面
     *
     * @param cid
     * @param request
     * @return
     * @throws UnsupportedEncodingException
     */
    @RequestMapping("/jumpToRemarkPage")
    public ModelAndView getRemarkPage(int cid, String courseCode, HttpServletRequest request) throws UnsupportedEncodingException {
        ModelAndView mav = new ModelAndView("remarkEditor");
        //取出原始评价数据（评分+文字评价）
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("loginUser");
        long uid = user.getUid();
        CourseSelected remark = courseSelectedService.getMyRemarkByCidAndUid(cid, (int) uid);

        String courseName = new String(request.getParameter("courseName").getBytes("iso-8859-1"), "utf-8"); //中文乱码修复

        mav.addObject("remark", remark);
        mav.addObject("courseName", courseName);
        mav.addObject("courseCode", courseCode);

        return mav;
    }

    /**
     * 将提交的评价数据存储，并更新Evaluation表
     */
    @RequestMapping("/updateRemark")
    @ResponseBody
    public String updateRemark(String content, String courseCode, int mark, int cid, HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("loginUser");
        long uid = user.getUid();

        // 修改评价
        int result = courseSelectedService.updateRemark(cid, (int)uid, content, mark);
        if (result == 1) {
            // 从course_selected表中，根据course_code选出当前课程的所有评分
            List<Integer> markList = courseSelectedService.getAllMarkByCourse_code(courseCode);
            // 统计markList中每个评分的个数
            Map<Integer, Integer> markMap = new HashMap<>();
            for(Integer ele:markList){
                markMap.putIfAbsent(ele, 0);
                markMap.compute(ele, (k, v)->(v+1));
            }
            Evaluation evaluation = new Evaluation();
            int rate_five = markMap.getOrDefault(5,0);
            int rate_four = markMap.getOrDefault(4,0);
            int rate_three = markMap.getOrDefault(3,0);
            int rate_two = markMap.getOrDefault(2,0);
            int rate_one = markMap.getOrDefault(1,0);
            // 统计总个数
            int total = rate_five + rate_four + rate_three + rate_two + rate_one;
            // 计算平均分
            double average = (5*rate_five + 4*rate_four + 3*rate_three +2*rate_two +rate_one)*1.0/total;
            average = Math.round(average*10)*1.0/10;
            // 封装数据
            evaluation.setCourse_code(courseCode);
            evaluation.setRate_five(rate_five);
            evaluation.setRate_four(rate_four);
            evaluation.setRate_three(rate_three);
            evaluation.setRate_two(rate_two);
            evaluation.setRate_one(rate_one);
            evaluation.setAverage_mark(average);
            evaluation.setTotal(total);
            // update Evaluation表的当前行数据
            int res1 = evaluationService.updateEvaluation(evaluation);
            // 如果无法update，说明不存在，insert
            if(res1 == 0){
                int res2 = evaluationService.insertEvaluation(evaluation);
                if (res2 == 0) {
                    return "fail";
                }
            }
         return "success";
        }
        return "fail";
    }

}
