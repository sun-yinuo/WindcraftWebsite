package com.sunyinuo.userconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class UserConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserConfigApplication.class, args);
    }

}
