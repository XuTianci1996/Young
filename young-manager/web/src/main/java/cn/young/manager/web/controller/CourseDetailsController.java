package cn.young.manager.web.controller;

import cn.young.manager.pojo.*;
import cn.young.manager.service.CourseSelectedService;
import cn.young.manager.service.CourseService;
import cn.young.manager.service.EvaluationService;
import cn.young.manager.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CourseDetailsController {
    @Autowired
    CourseService courseService;
    @Autowired
    EvaluationService evaluationService;
    @Autowired
    UserService userService;
    @Autowired
    CourseSelectedService courseSelectedService;

    private static Logger logger = Logger.getLogger(CourseDetailsController.class);

    //多了一个参数course_code，用于查询课程详情页的大部分信息
    //测试地址：http://localhost:8080/course/coursedetails?cid=1&course_code=AC15201
    @RequestMapping("/coursedetails")
    public ModelAndView courseDetails(int cid, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("coursedetails");
        //1 获取课程对象
        Course course = courseService.getCourseByCid(cid);
        String course_code = course.getCourseCode();
        //2 获取当前课程编号对应的评价表
        Evaluation evaluation = evaluationService.getEvaluationByCourse_code(course_code);
        //3 创建UserRemark对象List，然后获取每一条用户评价数据，并封装
        List<UserRemark> userRemarkList = new ArrayList<>();
        //3.1 获取course_selected表中的uid，用户评分，评价日期，文字评价
        List<CourseSelected> courseSelectedList = courseSelectedService.getAllRemarkByCourse_code(course_code);
        //3.2 根据上一步获得的uid，获取user表中的uname和uimage
        for (CourseSelected ele : courseSelectedList) {
            UserRemark userRemark = new UserRemark();
            System.out.println(ele.getContentDate());
            userRemark.setContent(ele.getContent());
            userRemark.setContent_date(ele.getContentDate());
            userRemark.setMark(ele.getMark());

            Long uidLong = ele.getUid();
            int uid = new Long(uidLong).intValue();
            User user = userService.getUnameAndUimage(uid);
            userRemark.setUname(user.getUname());
            userRemark.setUimage(user.getUimage());

            if(ele.getContent()!=null){
                userRemarkList.add(userRemark);
            }
        }

        //4 向mav中存入这些对象
        mav.addObject("Course", course);
        mav.addObject("Evaluation", evaluation);
        mav.addObject("UserRemarkList", userRemarkList);
        return mav;
    }


    //选择课程，传入cid和uid和course_code，返回选课是否成功的信息
    @RequestMapping("/chooseCourse")
    @ResponseBody
    public String chooseCourse(int cid, int uid, String course_code){
        //内部逻辑描述：
        //  1.对course表的操作：小于课程限选人数就course_selectnum加1，满了就返回FULL
        //  2.对course_selected表的操作：直接更改，不成功就新增（记得写入course_code）
        String chooseCourse = courseSelectedService.chooseCourse(cid, uid, course_code);

        return chooseCourse;
    }

    //退出课程，传入cid和uid，返回退课是否成功的信息
    @RequestMapping("/quitCourse")
    @ResponseBody
    public String quitCourse(int cid, int uid){
        //内部逻辑：
        // 一定要事务控制！！！
        //对course_selected表进行的操作：直接更改
        //对course表的操作：course_selectnum减1
        String quitCourse = courseSelectedService.quitCourse(cid, uid);

        return quitCourse;
    }

    //用户一旦登录，且跳到了课程详情页，就要判断当前用户选了这门课没，1选了，0没选
    @RequestMapping("/hasChoosed")
    @ResponseBody
    public String hasChoosed(int cid, int uid){
        int ischoose = courseSelectedService.hasChoosed(cid, uid);

        if(ischoose == 1){
            return "1";
        }else if(ischoose == 0){
            return "0";
        }

        //还有没找到该行数据的情况！！！

        return "0";
    }
}
