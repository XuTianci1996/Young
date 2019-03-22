package cn.young.manager.web.controller;

import cn.young.manager.pojo.HotCourse;
import cn.young.manager.service.HotCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class HotCourseController {
    @Autowired
    private HotCourseService service;
    @RequestMapping("/toIndexPage")
    public String toIndexPage(HttpServletRequest request) {
        List<HotCourse> findHotCourse = service.findAllHotCourse();
        request.getSession().setAttribute("HotCourse",findHotCourse );
        return "index";
    }

    @RequestMapping("/")
    public String toIndex(HttpServletRequest request) {
        List<HotCourse> findHotCourse = service.findAllHotCourse();
        request.getSession().setAttribute("HotCourse",findHotCourse );
        return "index";
    }
    /**
     * 对应页面的跳转
     * @param page
     * @return
     */
    @RequestMapping("{page}")
    public String getPage(@PathVariable String page, HttpServletRequest request){
        List<HotCourse> findHotCourse = service.findAllHotCourse();
        request.getSession().setAttribute("HotCourse",findHotCourse );
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
