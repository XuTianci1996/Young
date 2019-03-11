package cn.young.manager.web.controller;


import cn.young.common.pojo.EasyUIDataGrid;
import cn.young.common.pojo.YoungResult;
import cn.young.manager.pojo.Admin;
import cn.young.manager.pojo.Course;
import cn.young.manager.service.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 管理员页面Controller
 */
@Controller
public class AdminController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private UserService userService;

    @Autowired
    private EvaluationService evaluationService;

    @Autowired
    private CourseSelectedService courseSelectedService;

    @Autowired
    private AdminService adminService;
    /**
     * 管理员页面入口
     * @return
     */
    @RequestMapping("/adminlogin")
    public String getAdminLogin(){
        return "adminlogin";
    }

    @RequestMapping("/check/{username}/{password}")
    @ResponseBody
    public YoungResult check(HttpServletRequest request,HttpServletResponse response,@PathVariable String username,@PathVariable String password){
        Admin admin = adminService.adminLogin(username, password);
        if(username.equals(admin.getAname()) && password.equals(admin.getPassword())){
            CookieUtils.setCookie(request,response,"token","token",600);
            return YoungResult.ok();
        }
            return YoungResult.build(404,"错误");

    }


    @RequestMapping("/admin")
    public String getAdmin(HttpServletRequest request, HttpServletResponse response){
        String value = CookieUtils.getCookieValue(request,"token");
        if(StringUtils.isNoneBlank(value)){
            return "admin";
        }
        return "redirect:/adminlogin";
    }


    /**
     * 管理员页面显示
     * @param page
     * @return
     */
    @RequestMapping("{page}")
    public String getPage(@PathVariable String page){
        return page;
    }

    /**
     * 根据id选择课程
     * @param id
     * @return
     */
    @RequestMapping("course/{id}")
    @ResponseBody
    public Course getCourseByid(@PathVariable long id){
        Course courseinfo = courseService.getCourseinfoById(id);
        return courseinfo;
    }

    /**
     * 根据课程的选择人数，在后台显示所有的课程信息，由高到低
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/course/list")
    @ResponseBody
    public EasyUIDataGrid getAllCourse(int page,int rows){
        EasyUIDataGrid result = courseService.getUserList(page, rows);
        return result;
    }

    /**
     *查询用户
     */
    @RequestMapping("/user/list")
    @ResponseBody
    public EasyUIDataGrid getItemList(Integer page, Integer rows){
        EasyUIDataGrid result = userService.getUserList(page,rows);
        return result;
    }

    //删除用户
    @RequestMapping("/rest/user/delete")
    @ResponseBody
    public YoungResult deleteUser(@RequestParam(value="ids")long uid){
        YoungResult youngResult = userService.deleteUser( uid);
        return  youngResult;
    }

    @RequestMapping("/evaluation/list")
    @ResponseBody
    public EasyUIDataGrid getEvaluationList(Integer page, Integer rows){
        EasyUIDataGrid result = evaluationService.getEvaluation(page,rows);
        return result;
    }

    @RequestMapping("/courseselected/list")
    @ResponseBody
    public EasyUIDataGrid getCourseSelectedList(Integer page, Integer rows){
        EasyUIDataGrid result = courseSelectedService.getCourseSelectedList(page,rows);
        return result;
    }


}
