package com.sunyinuo.windcraftbackend.service.impl;

import com.sunyinuo.windcraftbackend.model.User;
import com.sunyinuo.windcraftbackend.service.LoginService;
import com.sunyinuo.windcraftbackend.utils.regex.SqlRegex;
import com.sunyinuo.windcraftbackend.utils.response.LoginResponse;
import com.sunyinuo.windcraftbackend.utils.response.RegisteredResponse;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 登陆业务逻辑层实现类
 * @author sunyinuo
 */
@Service
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
    public Integer login(String userName, String userPassword) {
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
