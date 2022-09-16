package com.sunyinuo.windcraftbackend.controller;

import com.sunyinuo.windcraftbackend.model.Ban;
import com.sunyinuo.windcraftbackend.model.Prohibit;
import com.sunyinuo.windcraftbackend.model.Warning;
import com.sunyinuo.windcraftbackend.service.api.impl.GetBanListServiceImpl;
import com.sunyinuo.windcraftbackend.service.api.impl.GetLoginStateServiceImpl;
import com.sunyinuo.windcraftbackend.service.api.impl.GetProhibitListServiceImpl;
import com.sunyinuo.windcraftbackend.service.api.impl.GetWaringListServiceImpl;
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
    private final GetProhibitListServiceImpl getProhibitListService;
    private final GetWaringListServiceImpl getWaringListService;

    public ApiController(GetBanListServiceImpl getBanListService, GetLoginStateServiceImpl getLoginStateService, GetProhibitListServiceImpl getProhibitListService, GetWaringListServiceImpl getWaringListService) {
        this.getBanListService = getBanListService;
        this.getLoginStateService = getLoginStateService;
        this.getProhibitListService = getProhibitListService;
        this.getWaringListService = getWaringListService;
    }

    @GetMapping("/getBanList")
    public List<Ban> getBanList(HttpServletRequest request){
        log.info("ip:{}", GetIp.getIpAddress(request));
        return getBanListService.getBanList();
    }

    @GetMapping("/getProhibitList")
    public List<Prohibit> getProhibitList(HttpServletRequest request){
        log.info("ip:{}", GetIp.getIpAddress(request));

        return getProhibitListService.getProhibitList();
    }

    @GetMapping("/getLoginState")
    public boolean getLoginState(HttpServletRequest request){
        String ip = GetIp.getIpAddress(request);
        log.info("ip:{}", ip);

        return getLoginStateService.getLoginState(ip);
    }

    @GetMapping("/getWaringList")
    public List<Warning> getWaringList(HttpServletRequest request){
        log.info("ip:{}", GetIp.getIpAddress(request));

        return getWaringListService.getWaringList();
    }

}
