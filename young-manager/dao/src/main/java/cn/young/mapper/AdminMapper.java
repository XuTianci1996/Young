package cn.young.mapper;

import cn.young.manager.pojo.Admin;

public interface AdminMapper {
    Admin adminLogin(String aname,String password);
}
