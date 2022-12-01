package com.sunyinuo.managementmassgecomments;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ManagementMassgeCommentsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManagementMassgeCommentsApplication.class, args);
    }

}
