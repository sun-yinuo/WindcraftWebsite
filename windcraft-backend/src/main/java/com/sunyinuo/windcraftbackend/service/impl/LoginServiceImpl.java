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

        //sql注入检查部分
        if (SqlRegex.sqlRegex(userName) || SqlRegex.sqlRegex(userPassword)){
            return RegisteredResponse.CODE_710;
        }

        List<User> userListByName = userService.getUserList();
        for (User user : userListByName) {
            //登陆成功
            if (userName.equals(user.getUserName()) && userPassword.equals(user.getUserPassword())){
                return LoginResponse.CODE_600;
            }
            //
            if (!userPassword.equals(user.getUserPassword())){
                return LoginResponse.CODE_610;
            }
            if (!userName.equals(user.getUserName())){
                return LoginResponse.CODE_610;
            }
        }

        return null;
    }
}
