package com.sunyinuo.windcraftbackend.controller;

import com.alibaba.fastjson.JSONObject;
import com.sunyinuo.windcraftbackend.service.impl.RegisteredServiceImpl;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 注册控制器
 * @author sunyinuo
 */
@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
@Component
public class RegisteredController {

    private final RegisteredServiceImpl registeredService;

    public RegisteredController(RegisteredServiceImpl registeredService) {
        this.registeredService = registeredService;
    }

    /**
     * 注册方法
     * @param jsonParam 前端参数
     * @return code
     */
    @PostMapping("/registered")
    public Integer registered(@RequestBody JSONObject jsonParam){
        String userName = (String) jsonParam.get("username");
        String userPassword = (String) jsonParam.get("password");

        return registeredService.registered(userName,userPassword);
    }
}
