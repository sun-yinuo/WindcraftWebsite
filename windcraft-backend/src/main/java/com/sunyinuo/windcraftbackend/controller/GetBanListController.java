package com.sunyinuo.windcraftbackend.controller;

import com.sunyinuo.windcraftbackend.model.Ban;
import com.sunyinuo.windcraftbackend.service.impl.GetBanListServiceImpl;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author sunyinuo
 */
@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
@Component
public class GetBanListController {
    private final GetBanListServiceImpl getBanListService;

    public GetBanListController(GetBanListServiceImpl getBanListService) {
        this.getBanListService = getBanListService;
    }

    @GetMapping("api/getBanList")
    public List<Ban> getBanList(){
        return getBanListService.getBanList();
    }

}
