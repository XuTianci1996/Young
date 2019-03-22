package cn.young.manager.web.controller;

import cn.young.manager.pojo.Course;
import cn.young.manager.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
@Controller
public class CourseController {
    @Autowired
    private CourseService service;

    @RequestMapping("/findCourseByLike")
    public String findHouseByLike(HttpServletRequest request, String keywords) {
//		List<Course> findHomeInfo = service.findCourseByLike(keywords);
//		request.getSession().removeAttribute("HotCourse");
//		request.getSession().setAttribute("HotCourse", findHomeInfo);
//		return "index";
        List<Course> findCourse = service.findCourseByLike(keywords);
        request.getSession().removeAttribute("HotCourse");
        request.getSession().removeAttribute("ha");
        request.getSession().setAttribute("Course", findCourse);
        System.out.println(keywords);

        return "index";
    }


}
