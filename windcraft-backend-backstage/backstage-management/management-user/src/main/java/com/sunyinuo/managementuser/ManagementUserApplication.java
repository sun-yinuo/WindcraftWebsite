package com.sunyinuo.managementuser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ManagementUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManagementUserApplication.class, args);
    }

}
