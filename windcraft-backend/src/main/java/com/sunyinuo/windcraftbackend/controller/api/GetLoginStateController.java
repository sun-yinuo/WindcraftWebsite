package com.sunyinuo.windcraftbackend.controller.api;

import com.sunyinuo.windcraftbackend.service.impl.GetLoginStateServiceImpl;
import com.sunyinuo.windcraftbackend.utils.ip.GetIp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 获取登陆状态
 * @author sunyinuo
 */
@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
@Component
@Slf4j
public class GetLoginStateController {

    private final GetLoginStateServiceImpl getLoginStateService;

    public GetLoginStateController(GetLoginStateServiceImpl getLoginStateService) {
        this.getLoginStateService = getLoginStateService;
    }

    @GetMapping("/api/getLoginState")
    public boolean getLoginState(HttpServletRequest request){
        String ip = GetIp.getIpAddress(request);
        log.info("ip:{}", ip);

        return getLoginStateService.getLoginState(ip);
    }

}
