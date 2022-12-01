package com.sunyinuo.opapplyforgame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class OpApplyforGameApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpApplyforGameApplication.class, args);
    }

}
