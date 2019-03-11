package cn.young.manager.web.controller;

import cn.young.manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class PageController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String getIndex(){
        return "index";
    }


}
