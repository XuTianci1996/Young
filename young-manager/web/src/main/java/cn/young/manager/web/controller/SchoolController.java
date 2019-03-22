package cn.young.manager.web.controller;

import cn.young.manager.pojo.Course;
import cn.young.manager.pojo.Page;
import cn.young.manager.pojo.School;
import cn.young.manager.service.CourseService;
import cn.young.manager.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class SchoolController {
    @Autowired
    SchoolService schoolService;
    @Autowired
    CourseService courseService;

    int curPage = 0 ;
    int curPage1 = 0 ;
    @RequestMapping("/schooldetail1")
    public String findCourseBySname(HttpServletRequest request,int page,int limit){

        long sid = 1;
        System.out.println(page+","+limit);
        School school = schoolService.getSchoolById(sid);

        Page p = new Page();
        p.setLimit(limit);
        p.setPage((page - 1) * limit);
        curPage = page;
        System.out.println(school.getSchName());
        p.setSchName(school.getSchName());
        List<Course> list = courseService.findCourseBySid(p);
        System.out.println(list.size());
        request.setAttribute("schoolname",school);
        request.setAttribute("courses",list);
        request.setAttribute("page",page);
        return "schooldetail1";

    }

    @RequestMapping("/schooldetail2")
    public String findCourseBySname2(HttpServletRequest request,int page,int limit){

        long sid = 2;
        System.out.println(page+","+limit);
        School school = schoolService.getSchoolById(sid);

        Page p = new Page();
        p.setLimit(limit);
        p.setPage((page - 1) * limit);
        curPage1= page;
        System.out.println(school.getSchName());
        p.setSchName(school.getSchName());
        List<Course> list = courseService.findCourseBySid(p);
        System.out.println(list.size());
        request.setAttribute("schoolname",school);
        request.setAttribute("courses",list);
        return "schooldetail2";

    }
    @RequestMapping("/courseNext")
    public String CourseNext(HttpServletRequest request){
        int page;
        curPage++;
        if(curPage<7) {
            page = curPage;
        }else page=6;

        int limit = 20;
        long sid = 1;
        System.out.println(page+","+limit);
        School school = schoolService.getSchoolById(sid);

        Page p = new Page();
        p.setLimit(limit);
        p.setPage((page - 1) * limit);

        System.out.println(school.getSchName());
        p.setSchName(school.getSchName());
        List<Course> list = courseService.findCourseBySid(p);
        System.out.println(list.size());
        request.setAttribute("schoolname",school);
        request.setAttribute("courses",list);
        return "schooldetail1";

    }
    @RequestMapping("/courseNext1")
    public String CourseNext1(HttpServletRequest request){

        int page;
        curPage1++;
        if(curPage1<15) {
            page = curPage1;
        }else page=14;

        int limit = 40;
        long sid = 2;
        System.out.println(page+","+limit);
        School school = schoolService.getSchoolById(sid);

        Page p = new Page();
        p.setLimit(limit);
        p.setPage((page - 1) * limit);

        System.out.println(school.getSchName());
        p.setSchName(school.getSchName());
        List<Course> list = courseService.findCourseBySid(p);
        System.out.println(list.size());
        request.setAttribute("schoolname",school);
        request.setAttribute("courses",list);
        return "schooldetail2";

    }
    @RequestMapping("/coursePre")
    public String CoursePre(HttpServletRequest request){
        int page;
        curPage--;
        if(curPage>0) {
            page = curPage;
        }else page=1;
        int limit = 20;
        long sid = 1;
        System.out.println(page+","+limit);
        School school = schoolService.getSchoolById(sid);
        Page p = new Page();
        p.setLimit(limit);
        p.setPage((page - 1) * limit);
        System.out.println(school.getSchName());
        p.setSchName(school.getSchName());
        List<Course> list = courseService.findCourseBySid(p);
        System.out.println(list.size());
        request.setAttribute("schoolname",school);
        request.setAttribute("courses",list);
        return "schooldetail1";

    }
    @RequestMapping("/coursePre1")
    public String CoursePre1(HttpServletRequest request){
        int page;
        curPage1--;
        if(curPage1>0) {
            page = curPage1;
        }else page=1;
        int limit = 40;
        long sid = 2;
        System.out.println(page+","+limit);
        School school = schoolService.getSchoolById(sid);

        Page p = new Page();
        p.setLimit(limit);
        p.setPage((page - 1) * limit);

        System.out.println(school.getSchName());
        p.setSchName(school.getSchName());
        List<Course> list = courseService.findCourseBySid(p);
        System.out.println(list.size());
        request.setAttribute("schoolname",school);
        request.setAttribute("courses",list);
        return "schooldetail2";

    }



}
