package cn.young.mapper;

import cn.young.manager.pojo.User;
import cn.young.manager.pojo.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Long uid);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Long uid);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    /**
     * 用户登录
     *
     * @return
     */
    User login(User user);

    /**
     * 用户注册
     *
     * @param user
     * @return
     */
    int regist(User user);
    /**
     * 修改密码
     * @return
     */
    int updateUserPwd(User user);
    /**
     * 检查旧密码
     * @param oldPwd
     * @return
     */
    User checkOldPwd(User user);
}