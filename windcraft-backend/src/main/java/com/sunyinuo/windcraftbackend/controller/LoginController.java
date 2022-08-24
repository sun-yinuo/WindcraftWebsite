package com.sunyinuo.windcraftbackend.controller;

import com.alibaba.fastjson.JSONObject;
import com.sunyinuo.windcraftbackend.service.impl.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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

    private final LoginServiceImpl loginService;

    public LoginController(LoginServiceImpl loginService) {
        this.loginService = loginService;
    }

    /**
     * 登陆方法
     * @param jsonParam 前端参数
     * @return code
     */
    @PostMapping("/login")
    public Integer login(@RequestBody JSONObject jsonParam){
        String userName = (String) jsonParam.get("username");
        String userPassword = (String) jsonParam.get("password");

        return loginService.login(userName,userPassword);
    }
}
