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
     *
     * @return
     */
    @RequestMapping("/adminlogin")
    public String getAdminLogin() {
        return "adminlogin";
    }

    /**
     * 管理员登录密码检查
     * @param request
     * @param response
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("/check/{username}/{password}")
    @ResponseBody
    public YoungResult check(HttpServletRequest request, HttpServletResponse response, @PathVariable String username, @PathVariable String password) {
        Admin admin = adminService.adminLogin(username, password);
        try {
            if (username.equals(admin.getAname()) && password.equals(admin.getPassword())) {
                CookieUtils.setCookie(request, response, "token", "token", 600);
                return YoungResult.ok();
            }
        } catch (Exception e) {

        }
        return YoungResult.build(404, "错误");
    }


    /**
     * 进入管理员页面
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/admin")
    public String getAdmin(HttpServletRequest request, HttpServletResponse response) {
        String value = CookieUtils.getCookieValue(request, "token");
        if (StringUtils.isNoneBlank(value)) {
            return "admin";
        }
        return "redirect:/adminlogin";
    }


    /**
     * 根据id选择课程
     *
     * @param id
     * @return
     */
    @RequestMapping("course/{id}")
    @ResponseBody
    public Course getCourseByid(@PathVariable long id) {
        Course courseinfo = courseService.getCourseinfoById(id);
        return courseinfo;
    }

    /**
     * 根据课程的选择人数，在后台显示所有的课程信息，由高到低
     *
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/course/list")
    @ResponseBody
    public EasyUIDataGrid getAllCourse(int page, int rows) {
        EasyUIDataGrid result = courseService.getCourseList(page, rows);
        return result;
    }

    /**
     * 查询用户
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/user/list")
    @ResponseBody
    public EasyUIDataGrid getItemList(Integer page, Integer rows) {
        EasyUIDataGrid result = userService.getUserList(page, rows);
        return result;
    }

    /**
     * 删除用户
     * @param uid
     * @return
     */
    @RequestMapping("/rest/user/delete")
    @ResponseBody
    public YoungResult deleteUser(@RequestParam(value = "ids") long uid) {
        YoungResult youngResult = userService.deleteUser(uid);
        return youngResult;
    }

    /**
     * 查看所有的评价
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/evaluation/list")
    @ResponseBody
    public EasyUIDataGrid getEvaluationList(Integer page, Integer rows) {
        EasyUIDataGrid result = evaluationService.getEvaluation(page, rows);
        return result;
    }

    /**
     * 查看所有的选课
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/courseselected/list")
    @ResponseBody
    public EasyUIDataGrid getCourseSelectedList(Integer page, Integer rows) {
        EasyUIDataGrid result = courseSelectedService.getCourseSelectedList(page, rows);
        return result;
    }

    /**
     * 删除不当评价
     * @param uid
     * @param cid
     * @return
     */
    @RequestMapping("/clearEvaluation/{uid}/{cid}")
    @ResponseBody
    public YoungResult clearEvaluation(@PathVariable long uid, @PathVariable long cid) {
        courseSelectedService.clearEvaluation(uid, cid);
        return YoungResult.ok();
    }

}
