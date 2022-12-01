package com.sunyinuo.usersignin.mapper;

import com.sunyinuo.usersignin.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * User表mapper
 * @author sunyinuo
 */
@Mapper
public interface UserMapper {
    /**
     * 获取所有用户
     * @return 用户实体类List
     */
    List<User> getUserList();


    /**
     * 根据id查询所有用户
     * @param id id
     * @return 用户实体类
     */
    User getUserById(int id);

    /**
     * 根据userName查询所有用户
     * @param userName 用户名
     * @return 用户实体类
     */
    User getUserByName(String userName);

    /**
     * 根据userPassword查询所有用户
     * @param userPassword 密码
     * @return 用户实体类
     */
    List<User> getUserByPassword(String userPassword);

    /**
     * 根据time查询所有用户
     * @param time 时间
     * @return 用户实体类
     */
    List<User> getUserByTime(long time);

    /**
     * 根据ip查询所有用户
     * @param ip ip
     * @return 用户实体类
     */
    List<User> getUserByIp(String ip);

    /**
     * 添加用户
     * @param user 用户实体类
     * @return 是否成功
     */
    int addUser(User user);

    /**
     * 根据userName删除用户
     * @param userName 用户名
     * @return 是否成功
     */
    int deleteUserByName(String userName);
}
