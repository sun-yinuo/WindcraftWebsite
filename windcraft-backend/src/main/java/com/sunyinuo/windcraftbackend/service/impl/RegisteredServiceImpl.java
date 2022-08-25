package com.sunyinuo.windcraftbackend.service.impl;

import com.sunyinuo.windcraftbackend.model.User;
import com.sunyinuo.windcraftbackend.service.RegisteredService;
import com.sunyinuo.windcraftbackend.utils.ip.GetIp;
import com.sunyinuo.windcraftbackend.utils.regex.PasswordRegex;
import com.sunyinuo.windcraftbackend.utils.regex.SqlRegex;
import com.sunyinuo.windcraftbackend.utils.response.RegisteredResponse;
import org.springframework.stereotype.Service;


/**
 * 登陆业务逻辑层实现类
 * @author sunyinuo
 */
@Service
public class RegisteredServiceImpl implements RegisteredService {

    private final UserServiceImpl userService;

    public RegisteredServiceImpl(UserServiceImpl userService) {
        this.userService = userService;
    }

    /**
     * 注册
     * @param userName     用户名
     * @param userPassword 密码
     * @return code
     */
    @Override
    public Integer registered(String userName, String userPassword) {
        User userListByName = userService.getUserByName(userName);

        //sql注入检查部分
        if (SqlRegex.sqlRegex(userName) || SqlRegex.sqlRegex(userPassword)){
            return RegisteredResponse.CODE_710;
        }

        //用户名或密码不合规
        if (PasswordRegex.passwordRegex(userPassword)){
            return RegisteredResponse.CODE_770;
        }

        //用户名重复
        if (userListByName == null){
            if (!PasswordRegex.passwordRegex(userPassword)){
                User user = new User();

                //单位ms
                user.setTime(System.currentTimeMillis());
                user.setUserName(userName);
                user.setUserPassword(userPassword);
                user.setIp(GetIp.getIp());

                if (userService.addUser(user) == 1){
                    return RegisteredResponse.CODE_700;
                }
                if (userService.addUser(user) == 0){
                    return RegisteredResponse.CODE_500;
                }
            }
        }

        if (userListByName != null){
            return RegisteredResponse.CODE_750;
        }

        return null;
    }
}
