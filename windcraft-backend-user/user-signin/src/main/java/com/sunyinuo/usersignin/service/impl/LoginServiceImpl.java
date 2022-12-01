package com.sunyinuo.usersignin.service.impl;

import com.sunyinuo.usersignin.model.User;
import com.sunyinuo.usersignin.service.LoginService;
import com.sunyinuo.usersignin.service.db.impl.UserServiceImpl;
import com.sunyinuo.usersignin.utils.regex.SqlRegex;
import com.sunyinuo.usersignin.utils.response.LoginResponse;
import com.sunyinuo.usersignin.utils.response.RegisteredResponse;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

/**
 * 登陆业务逻辑层实现类
 * @author sunyinuo
 */
@Service
@CacheConfig(cacheNames = "loginStateCache")
public class LoginServiceImpl implements LoginService {

    private final UserServiceImpl userService;

    public LoginServiceImpl(UserServiceImpl userService) {
        this.userService = userService;
    }

    /**
     * 登陆
     * @param userName     用户名
     * @param userPassword 密码
     * @return code
     */
    @Override
    @CachePut(condition = "#result == 600",value = "loginStateCache", key = "#ip")
    public Integer login(String userName, String userPassword, String ip) {
        User userList = userService.getUserByName(userName);

        //sql注入检查部分
        if (SqlRegex.sqlRegex(userName) || SqlRegex.sqlRegex(userPassword)){
            return RegisteredResponse.CODE_710;
        }

        if (userList != null){
            //登陆成功
            if (userName.equals(userList.getUserName()) && userPassword.equals(userList.getUserPassword())) {
                return LoginResponse.CODE_600;
            }
            if (!userPassword.equals(userList.getUserPassword())){
                return LoginResponse.CODE_610;
            }
            if (!userName.equals(userList.getUserName())){
                return LoginResponse.CODE_610;
            }
        }
        if (userList == null){
            return LoginResponse.CODE_610;
        }
        return null;
    }
}
