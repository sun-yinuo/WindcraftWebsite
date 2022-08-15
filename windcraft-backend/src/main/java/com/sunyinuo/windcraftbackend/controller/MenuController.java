package com.sunyinuo.windcraftbackend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 导航栏控制器
 * @author sunyinuo
 */
@Controller
public class MenuController {

    @GetMapping("/main")
    @ResponseBody
    @CrossOrigin(origins = "*",maxAge = 3600)
    public Integer gotoMainPage(){
        System.out.println("aaaaa");
        return 200;
    }
}
