package cn.young.manager.web.controller;


import cn.young.common.pojo.EasyUIDataGrid;
import cn.young.common.pojo.YoungResult;
import cn.young.manager.pojo.User;
import cn.young.manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/login")
    @ResponseBody
    public String toUserPage(String username, String password, HttpServletRequest req ) {
        User user = new User();
        user.setUname(username);
        user.setPassword(password);
        User loginUser = userService.login(user);
        if(loginUser!=null) {
            req.getSession().setAttribute("loginUser", loginUser);
            return "OK";
        }
        return "FAIL";

    }

    @RequestMapping("/signout")
    public String signout(HttpSession session) {
        session.invalidate();
        return "redirect:toIndexPage";
    }

    @RequestMapping("/regist")
    @ResponseBody
    public String regist(User user) {
        int regist;
        try {
            regist = userService.regist(user);
            if(regist>0) {
                return "OK";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "FAIL";
    }

//    //删除用户
//    @RequestMapping(value = "/rest/user/delete",method = RequestMethod.POST)
//    @ResponseBody
//    public YoungResult deleteUser(@RequestParam(value="ids")long uid){
//        YoungResult youngResult = userService.deleteUser( uid);
//        System.out.println(youngResult.getStatus());
//        return  youngResult;
//    }
}
