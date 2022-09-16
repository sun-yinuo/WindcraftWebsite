package com.sunyinuo.windcraftbackend.service.impl;


import com.sunyinuo.windcraftbackend.model.Prohibit;
import com.sunyinuo.windcraftbackend.service.db.impl.ProhibitServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ProhibitServiceImplTest {

    @Autowired
    private ProhibitServiceImpl prohibitService;

    @Test
    void getProhibitList(){
        List<Prohibit> prohibitList = prohibitService.getProhibitList();
        System.out.println(prohibitList);
    }
}