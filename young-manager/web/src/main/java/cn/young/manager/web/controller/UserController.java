package cn.young.manager.web.controller;


import cn.young.manager.pojo.User;
import cn.young.manager.service.UserService;
import cn.young.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserMapper userMapper;

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
        String[] split = user.getPassword().split(",");
        user.setPassword(split[0]);
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


    @RequestMapping("/toUserSystem")
    public String toUserSystemPage() {
        return "customer";
    }

    @RequestMapping("/toUserRentalPage")
    public String toUserRentalPage() {
        return "myrental";
    }

    @RequestMapping("/welcome")
    public String toWelcomePage() {
        return "welcome";
    }


    @RequestMapping("/updateUserPwd")
    @ResponseBody
    public String updateUserPwd(String id,String newPwd,String oldPwd) {
        User oldUser = new User();
        oldUser.setUid(Long.parseLong(id));
        oldPwd = DigestUtils.md5DigestAsHex(oldPwd.getBytes());
        oldUser.setPassword(oldPwd);
        User checkUser = userService.checkOldPwd(oldUser);
        if(checkUser!=null) {
            User newUser = new User();
            newUser.setUid(Long.parseLong(id));
            newPwd = DigestUtils.md5DigestAsHex(newPwd.getBytes());
            newUser.setPassword(newPwd);
            int n = userService.updateUserPwd(newUser);
            if(n>0) {
                return "OK";
            }
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
