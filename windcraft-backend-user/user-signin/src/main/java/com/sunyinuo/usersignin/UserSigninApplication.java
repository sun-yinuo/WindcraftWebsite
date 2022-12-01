package com.sunyinuo.usersignin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class UserSigninApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserSigninApplication.class, args);
    }

}
