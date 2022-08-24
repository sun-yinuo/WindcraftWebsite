package com.sunyinuo.windcraftbackend.service.impl;

import com.sunyinuo.windcraftbackend.model.User;
import com.sunyinuo.windcraftbackend.service.LoginService;
import com.sunyinuo.windcraftbackend.utils.regex.SqlRegex;
import com.sunyinuo.windcraftbackend.utils.response.LoginResponse;
import com.sunyinuo.windcraftbackend.utils.response.RegisteredResponse;
import org.springframework.stereotype.Service;

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

        User userListByName = userService.getUserByName(userName);

        //sql注入检查部分
        if (SqlRegex.sqlRegex(userName) || SqlRegex.sqlRegex(userPassword)){
            return RegisteredResponse.CODE_710;
        }

        //登陆部分
        if (userListByName != null){
            //登陆成功
            if (userName.equals(userListByName.getUserName()) && userPassword.equals(userListByName.getUserPassword())){
                return LoginResponse.CODE_600;
            }

            //todo 两个都错误时无法正常返回值(系统懵了
            //提示用户名或密码错误
            if (!userName.equals(userListByName.getUserName()) || !userPassword.equals(userListByName.getUserPassword())){
                return LoginResponse.CODE_610;
            }

        }

        return null;
    }
}
