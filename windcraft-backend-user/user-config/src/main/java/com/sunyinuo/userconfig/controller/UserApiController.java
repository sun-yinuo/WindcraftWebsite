package com.sunyinuo.userconfig.controller;

import com.sunyinuo.userconfig.service.impl.UserLogOutServiceImpl;
import com.sunyinuo.userconfig.utils.ip.GetIp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import result.Result;

import javax.servlet.http.HttpServletRequest;

/**
 * @author sunyinuo
 */
@RestController
@RequestMapping("/userconfig/api")
@Slf4j
public class UserApiController {
    private final UserLogOutServiceImpl userLogOutService;

    public UserApiController(UserLogOutServiceImpl userLogOutService) {
        this.userLogOutService = userLogOutService;
    }


    @PostMapping("/logOut")
    public Result userLogOut(@RequestParam("user") String confirmUser, HttpServletRequest request){
        String ip = GetIp.getIpAddress(request);
        return userLogOutService.userLogOut(confirmUser,ip);
    }

}
