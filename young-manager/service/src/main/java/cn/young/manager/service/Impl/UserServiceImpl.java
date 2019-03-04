package cn.young.manager.service.Impl;

import cn.young.manager.dao.UserMapper;
import cn.young.manager.pojo.User;
import cn.young.manager.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserById(long id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
