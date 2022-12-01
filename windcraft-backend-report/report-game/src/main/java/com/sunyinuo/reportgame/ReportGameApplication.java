package com.sunyinuo.reportgame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 游戏外挂举报服务
 * @author martin
 */

@SpringBootApplication
@EnableDiscoveryClient
public class ReportGameApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReportGameApplication.class, args);
    }

}
