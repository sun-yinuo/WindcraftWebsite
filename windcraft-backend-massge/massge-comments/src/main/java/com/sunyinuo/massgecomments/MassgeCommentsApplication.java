package com.sunyinuo.massgecomments;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MassgeCommentsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MassgeCommentsApplication.class, args);
    }

}
