//package cn.young.manager.web.controller;
//
//
//import cn.young.common.pojo.EasyUIDataGrid;
//import cn.young.common.pojo.YoungResult;
//import cn.young.manager.pojo.User;
//import cn.young.manager.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//@Controller
//public class UserController {
//
//    @Autowired
//    UserService userService;
//
//    @RequestMapping("user/{id}")
//    @ResponseBody
//    public User getUserById(@PathVariable long id){
//        User user = userService.getUserById(id);
//        System.out.println(user);
//        if(user!=null) return user;
//        return null;
//    }
//
//    //使得在查询商品里面呈现分页过后的数据表格
//    @RequestMapping("/user/list")
//    @ResponseBody
//    public EasyUIDataGrid getItemList(Integer page, Integer rows){
//        EasyUIDataGrid result = userService.getUserList(page,rows);
//        return result;
//    }
//
//    //删除用户
//    @RequestMapping(value = "/rest/user/delete",method = RequestMethod.POST)
//    @ResponseBody
//    public YoungResult deleteUser(@RequestParam(value="ids")long uid){
//        YoungResult youngResult = userService.deleteUser( uid);
//        System.out.println(youngResult.getStatus());
//        return  youngResult;
//    }
//}
