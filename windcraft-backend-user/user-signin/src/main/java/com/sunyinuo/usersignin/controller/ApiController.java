package com.sunyinuo.usersignin.controller;

import com.sunyinuo.usersignin.service.api.impl.GetLoginStateServiceImpl;
import com.sunyinuo.usersignin.utils.ip.GetIp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * api控制器
 * @author sunyinuo
 */
@RestController
@RequestMapping("/usersignin/api")
@Component
@Slf4j
public class ApiController {


    private final GetLoginStateServiceImpl getLoginStateService;

    public ApiController(GetLoginStateServiceImpl getLoginStateService) {
        this.getLoginStateService = getLoginStateService;
    }

    @GetMapping("/getLoginState")
    public boolean getLoginState(HttpServletRequest request){
        String ip = GetIp.getIpAddress(request);
        log.info("ip:{}", ip);

        return getLoginStateService.getLoginState(ip);
    }


}
