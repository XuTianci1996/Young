package cn.young.manager.service.Impl;

import cn.young.manager.pojo.Admin;
import cn.young.manager.service.AdminService;
import cn.young.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin adminLogin(String aname, String password) {
        Admin admin = adminMapper.adminLogin(aname, password);
        return admin;
    }
}
