package com.sunyinuo.usersignin.controller;

import com.alibaba.fastjson.JSONObject;
import com.sunyinuo.usersignin.service.impl.RegisteredServiceImpl;
import com.sunyinuo.usersignin.utils.ip.GetIp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 注册控制器
 * @author sunyinuo
 */
@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
@Component
@Slf4j
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
    public Integer registered(@RequestBody JSONObject jsonParam, HttpServletRequest request){
        String userName = (String) jsonParam.get("username");
        String userPassword = (String) jsonParam.get("password");
        String ip = GetIp.getIpAddress(request);
        log.info("ip:{}", ip);

        return registeredService.registered(userName,userPassword,ip);
    }
}
