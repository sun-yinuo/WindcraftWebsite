package com.sunyinuo.massgedynamic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MassgeDynamicApplication {

    public static void main(String[] args) {
        SpringApplication.run(MassgeDynamicApplication.class, args);
    }

}
