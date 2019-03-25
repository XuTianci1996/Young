package cn.young.manager.web.controller;

import cn.young.manager.pojo.Course;
import cn.young.manager.pojo.HotCourse;
import cn.young.manager.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class HotCourseController {
    @Autowired
    private CourseService service;

    /**
     * To:袁双双：
     *      我把你的两个方法合并了，因为我看方法体里的东西都一样。里面还加了推荐课程的代码，如果修改的话不要把我的覆盖掉哦
     *       ——章海翔
     * @param request
     * @return
     */
    @RequestMapping(value = {"/toIndexPage", "/"})
    public String toIndexPage(HttpServletRequest request) {
        List<Course> findHotCourse = service.findAllHotCourse();
        List<Course> recommendCourse = service.getRecommendCourse();

        request.getSession().setAttribute("HotCourse",findHotCourse );
        request.getSession().setAttribute("RecommendCourse",recommendCourse );

        return "index";
    }
    /**
     * 对应页面的跳转
     * @param page
     * @return
     */
    @RequestMapping("/{page}")
    public String getPage(@PathVariable String page, HttpServletRequest request){
        List<Course> findHotCourse = service.findAllHotCourse();
        List<Course> recommendCourse = service.getRecommendCourse();

        request.getSession().setAttribute("HotCourse",findHotCourse );
        request.getSession().setAttribute("RecommendCourse",recommendCourse );
        return page;
    }
//    @RequestMapping("/toDetailsPage")
//    public String toDetailsPage(int id,HttpServletRequest request) {
//       HotCourse course = service.findAllHouse(id);
//        List<String> list = new ArrayList<String>();
//        String[] split = HouseDetails.getHouseDetailsImg().split("~");
//        for(int i=0;i<split.length;i++) {
//            list.add(split[i]);
//        }
//        request.getSession().setAttribute("Details", HouseDetails);
//        request.getSession().setAttribute("DetailsImg", list);
//        return "housedetails.jsp";
//    }


}
