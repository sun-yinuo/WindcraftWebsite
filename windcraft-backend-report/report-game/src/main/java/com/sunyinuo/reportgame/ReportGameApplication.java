package com.sunyinuo.reportgame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

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

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
