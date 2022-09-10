package com.sunyinuo.windcraftbackend.controller;

import com.sunyinuo.windcraftbackend.model.Ban;
import com.sunyinuo.windcraftbackend.service.impl.GetBanListServiceImpl;
import com.sunyinuo.windcraftbackend.service.impl.GetLoginStateServiceImpl;
import com.sunyinuo.windcraftbackend.utils.ip.GetIp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * api控制器
 * @author sunyinuo
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*",maxAge = 3600)
@Component
@Slf4j
public class ApiController {

    private final GetBanListServiceImpl getBanListService;
    private final GetLoginStateServiceImpl getLoginStateService;


    public ApiController(GetBanListServiceImpl getBanListService, GetLoginStateServiceImpl getLoginStateService) {
        this.getBanListService = getBanListService;
        this.getLoginStateService = getLoginStateService;
    }

    @GetMapping("/getBanList")
    public List<Ban> getBanList(){
        return getBanListService.getBanList();
    }

    @GetMapping("/getLoginState")
    public boolean getLoginState(HttpServletRequest request){
        String ip = GetIp.getIpAddress(request);
        log.info("ip:{}", ip);

        return getLoginStateService.getLoginState(ip);
    }

}
