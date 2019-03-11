package cn.young.manager.service.Impl;

import cn.young.common.pojo.EasyUIDataGrid;
import cn.young.common.pojo.YoungResult;
import cn.young.mapper.UserMapper;
import cn.young.manager.pojo.User;
import cn.young.manager.pojo.UserExample;
import cn.young.manager.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(User user) {
        System.out.println("login:"+user.getPassword());
        String password = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
        System.out.println(password);
        user.setPassword(password);
        return userMapper.login(user);
    }

    @Override
    public int regist(User user) {
        String password = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
        user.setPassword(password);
        return userMapper.regist(user);
    }

    @Override
    public int updateUserPwd(User user) {
        return userMapper.updateUserPwd(user);
    }

    @Override
    public User checkOldPwd(User user) {
        return userMapper.checkOldPwd(user);
    }

    @Override
    public User getUserById(long uid) {

        return userMapper.selectByPrimaryKey(uid);
    }

    @Override
    public EasyUIDataGrid getUserList(int page, int rows) {
        //设置分页信息
        PageHelper.startPage(page,rows);
        //执行查询
        UserExample userExample = new UserExample();
        List<User> userList = userMapper.selectByExample(userExample);
        PageInfo<User> pageInfo = new PageInfo(userList);
        System.out.println();
        //创建一个返回值对象
        EasyUIDataGrid result = new EasyUIDataGrid();
        result.setRows(userList);
        result.setTotal(pageInfo.getTotal());
        return result;
    }

    @Override
    public YoungResult deleteUser(@RequestParam(value="ids") long uid) {
        userMapper.deleteByPrimaryKey(uid);
        return YoungResult.ok();
    }
}
