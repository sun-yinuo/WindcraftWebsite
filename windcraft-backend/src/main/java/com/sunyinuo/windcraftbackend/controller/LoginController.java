package com.sunyinuo.windcraftbackend.controller;

import com.alibaba.fastjson.JSONObject;
import com.sunyinuo.windcraftbackend.model.User;
import com.sunyinuo.windcraftbackend.service.impl.UserServiceImpl;
import com.sunyinuo.windcraftbackend.utils.ip.GetIp;
import com.sunyinuo.windcraftbackend.utils.regex.PasswordRegex;
import com.sunyinuo.windcraftbackend.utils.regex.SqlRegex;
import com.sunyinuo.windcraftbackend.utils.response.LoginResponse;
import com.sunyinuo.windcraftbackend.utils.response.RegisteredResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

/**
 * 登陆/注册控制器
 * @author sunyinuo
 */
@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
@Component
public class LoginController {
    private final UserServiceImpl userService;

    public LoginController(UserServiceImpl userService) {
        this.userService = userService;
    }

    /**登陆失败次数**/
    private static int numberOfFailures = 0;
    /**登陆失败次数上限**/
    private static final int NUMBER_OF_FAILURES_CEILING = 3;

    /**
     * 登陆方法
     * @param jsonParam 前端参数
     */
    @PostMapping("/login")
    public String login(@RequestBody JSONObject jsonParam){
        String userName = (String) jsonParam.get("username");
        String userPassword = (String) jsonParam.get("password");
        //获取用户列表，条件userName
        User userListByName = userService.getUserByName(userName);

        //sql注入检查部分
        if (SqlRegex.sqlRegex(userName) || SqlRegex.sqlRegex(userPassword)){
            return RegisteredResponse.CODE_710;
        }

        //注册部分
        if (userListByName == null){
            if (PasswordRegex.passwordRegex(userPassword)){
                return RegisteredResponse.CODE_770;
            }

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

        //登陆部分
        if (userListByName != null){
            //登陆成功
            if (userName.equals(userListByName.getUserName()) && userPassword.equals(userListByName.getUserPassword())){
                numberOfFailures = 0;
                return LoginResponse.CODE_600;
            }

            //提示可能触发逻辑漏洞
            if (numberOfFailures == NUMBER_OF_FAILURES_CEILING){
                numberOfFailures = 0;
                return LoginResponse.CODE_660;
            }

            //提示用户名或密码错误
            if (!userName.equals(userListByName.getUserName()) || !userPassword.equals(userListByName.getUserPassword())){
                numberOfFailures++;
                return LoginResponse.CODE_610;
            }
        }
        return null;
    }
}
