package cn.young.manager.web.controller;


import cn.young.manager.pojo.User;
import cn.young.manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("user/{id}")
    @ResponseBody
    public User getUserById(@PathVariable long id){
        User user = userService.getUserById(id);
        System.out.println(user);
        if(user!=null) return user;
        return null;
    }
}
