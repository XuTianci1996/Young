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
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

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
