package com.sunyinuo.opapplyforwebsite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class OpApplyforWebsiteApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpApplyforWebsiteApplication.class, args);
    }

}
