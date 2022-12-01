package com.sunyinuo.usersignin.service.db.impl;

import com.sunyinuo.usersignin.mapper.UserMapper;
import com.sunyinuo.usersignin.model.User;
import com.sunyinuo.usersignin.service.db.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * User表service层
 * @author sunyinuo
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    /**
     * 获取所有用户
     * @return 用户实体类List
     */
    @Override
    public List<User> getUserList() {
        return userMapper.getUserList();
    }

    /**
     * 根据id查询所有用户
     * @param id id
     * @return 用户实体类
     */
    @Override
    public User getUserById(int id) {
        return userMapper.getUserById(id);
    }

    /**
     * 根据userName查询所有用户
     * @param userName 用户名
     * @return 用户实体类
     */
    @Override
    public User getUserByName(String userName) {
        return userMapper.getUserByName(userName);
    }

    /**
     * 根据userPassword查询所有用户
     * @param userPassword 密码
     * @return 用户实体类
     */
    @Override
    public List<User> getUserByPassword(String userPassword) {
        return userMapper.getUserByPassword(userPassword);
    }

    /**
     * 根据time查询所有用户
     * @param time 时间
     * @return 用户实体类
     */
    @Override
    public List<User> getUserByTime(long time) {
        return userMapper.getUserByTime(time);
    }

    /**
     * 根据ip查询所有用户
     * @param ip ip
     * @return 用户实体类
     */
    @Override
    public List<User> getUserByIp(String ip) {
        return userMapper.getUserByIp(ip);
    }

    /**
     * 添加用户
     * @param user 用户实体类
     * @return 是否成功
     */
    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    /**
     * 根据userName删除用户
     * @param userName 用户名
     * @return 是否成功
     */
    @Override
    public int deleteUserByName(String userName) {
        return userMapper.deleteUserByName(userName);
    }
}
