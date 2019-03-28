package cn.young.manager.web.controller;

import cn.young.manager.pojo.Course;
import cn.young.manager.pojo.PagingData;
import cn.young.manager.pojo.User;
import cn.young.manager.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CourseController {
    @Autowired
    private CourseService service;

    /**
     * 课程查询
     * @param request
     * @param keywords
     * @return
     */
    @RequestMapping("/findCourseByLike")
    public String findHouseByLike(HttpServletRequest request, String keywords) {
        Boolean flag = null;
        if (keywords!=null){
            flag=true;
        }
        request.getSession().setAttribute("key", keywords);
        List<Course> findCourse = service.findCourseByLike(keywords);
        request.getSession().removeAttribute("HotCourse");
        request.getSession().removeAttribute("ha");
        request.getSession().setAttribute("Course", findCourse);
        request.getSession().setAttribute("flag", flag);
        //System.out.println(keywords);
        return "indexTo";
    }


    /**
     * 课程分页
     * @param page
     * @param limit
     * @param request
     * @return
     */
    @RequestMapping("/myCourseInfo")
    @ResponseBody
    public PagingData<Course> getMyCourseByUid(int page, int limit, HttpServletRequest request) {
//        System.out.println("选课页："+page);
//        System.out.println("每页几条："+limit);
        User user = (User) request.getSession().getAttribute("loginUser");
        // 设置uid
        long uidLong = user.getUid();
        return service.getMyCourseByUid((int) uidLong, page, limit);
    }

}
