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

    private final User user = new User();

    /**
     * 登陆方法
     * @param jsonParam 前端参数
     */
    @PostMapping("/login")
    public String login(@RequestBody JSONObject jsonParam){
        String userName = (String) jsonParam.get("username");
        String userPassword = (String) jsonParam.get("password");

        //判断是否有sql注入
        if (!SqlRegex.sqlRegex(userName) && !SqlRegex.sqlRegex(userPassword)){
            //获取用户列表，条件userName
            User userListByName = userService.getUserByName(userName);

            if (userListByName != null){
                //进入登陆部分
                if (userName.equals(userListByName.getUserName()) && userPassword.equals(userListByName.getUserPassword())){
                    numberOfFailures = 0;
                    //返回600ok
                    return LoginResponse.CODE_600;
                }else {
                    //如果失败=3次，就怀疑触发逻辑漏洞
                    if (numberOfFailures == NUMBER_OF_FAILURES_CEILING){
                        numberOfFailures = 0;
                        //返回660提示用户
                        return LoginResponse.CODE_660;
                    }else {
                        numberOfFailures++;
                        //返回610用户名密码错误响应
                        return LoginResponse.CODE_610;
                    }
                }
            }else {
                //进入注册部分
                if (!PasswordRegex.passwordRegex(userPassword)){
                    user.setId(0);
                    user.setUserName(userName);
                    user.setUserPassword(userPassword);
                    user.setIp(GetIp.getIp());
                    //单位ms
                    user.setTime(System.currentTimeMillis());

                    //判断是否成功
                    if (userService.addUser(user) == 1){
                        //返回700注册成功
                        return RegisteredResponse.CODE_700;
                    }else {
                        //返回500注册失败
                        return RegisteredResponse.CODE_500;
                    }
                }else {
                    //返回770 用户名或密码不符合规范响应
                    return RegisteredResponse.CODE_770;
                }
            }
        }else {
            //返回710响应
            return RegisteredResponse.CODE_710;
        }
    }
}
