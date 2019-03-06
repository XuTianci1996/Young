package cn.young.manager.web.controller;


import cn.young.common.pojo.EasyUIDataGrid;
import cn.young.manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PageController {

    //@Autowired
    //private UserService userService;

    @RequestMapping("/")
    public String getIndex(){
        return "index";
    }



    //使得在新增商品，查询商品等左边的导航栏中点击过后可以打开右边的嵌入式页面
    @RequestMapping("{page}")
    public String getPage(@PathVariable String page){
        return page;
    }
}
