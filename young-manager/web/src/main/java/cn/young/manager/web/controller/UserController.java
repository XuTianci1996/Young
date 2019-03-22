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
import java.util.Random;

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

    @RequestMapping(value = {"/signout", "/logout"})
    public String signout(HttpSession session) {
        session.invalidate();
        return "redirect:toIndexPage";
    }

    @RequestMapping("/regist")
    @ResponseBody
    public String regist(User user) {
        String[] split = user.getPassword().split(",");
        user.setPassword(split[0]);
        Random random = new Random();
        int num = random.nextInt(1000);
        user.setUimage("https://images.nowcoder.com/head/"+ num +"m.png");
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
    public String toUserSystemPage(HttpServletRequest request) {
        HttpSession session = request.getSession();
        User loginUser = (User) session.getAttribute("loginUser");
        if (loginUser != null){
            return "customer";
        }else {
            return "redirect:index";
        }
    }

//    @RequestMapping("/toUserRentalPage")
//    public String toUserRentalPage() {
//        return "myrental";
//    }

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

    @RequestMapping("/myorder")
    public String myCourseInfo(HttpServletRequest request){
        HttpSession session = request.getSession();
        User loginUser = (User) session.getAttribute("loginUser");
        if (loginUser != null){
            return "myorder";
        }else {
            return "redirect:index";
        }

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
