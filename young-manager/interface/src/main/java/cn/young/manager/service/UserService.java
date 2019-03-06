package cn.young.manager.service;

import cn.young.common.pojo.EasyUIDataGrid;
import cn.young.common.pojo.YoungResult;
import cn.young.manager.pojo.User;


public interface UserService {

    User getUserById(long uid);

    //获取所有的用户
    EasyUIDataGrid getUserList(int page,int rows);

    //删除用户
    YoungResult deleteUser(long uid);
}
