package com.sunyinuo.bancrud.controller;

import com.sunyinuo.bancrud.model.Ban;
import com.sunyinuo.bancrud.model.Prohibit;
import com.sunyinuo.bancrud.model.Warning;
import com.sunyinuo.bancrud.service.api.impl.GetBanListServiceImpl;
import com.sunyinuo.bancrud.service.api.impl.GetProhibitListServiceImpl;
import com.sunyinuo.bancrud.service.api.impl.GetWaringListServiceImpl;
import com.sunyinuo.bancrud.utils.ip.GetIp;
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
    private final GetProhibitListServiceImpl getProhibitListService;
    private final GetWaringListServiceImpl getWaringListService;

    public ApiController(GetBanListServiceImpl getBanListService, GetProhibitListServiceImpl getProhibitListService, GetWaringListServiceImpl getWaringListService) {
        this.getBanListService = getBanListService;
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

    @GetMapping("/getWaringList")
    public List<Warning> getWaringList(HttpServletRequest request){
        log.info("ip:{}", GetIp.getIpAddress(request));

        return getWaringListService.getWaringList();
    }

}
