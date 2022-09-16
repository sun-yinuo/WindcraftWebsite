package com.sunyinuo.windcraftbackend.service.impl;

import com.sunyinuo.windcraftbackend.model.Warning;
import com.sunyinuo.windcraftbackend.service.db.impl.WarningServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class WarningServiceImplTest {

    @Autowired
    private WarningServiceImpl warningService;

    @Test
    void getWarningList() {
        List<Warning> warningList = warningService.getWarningList();
        System.out.println(warningList);
    }
}