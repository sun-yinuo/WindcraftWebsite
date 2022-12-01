package com.sunyinuo.searchdynamic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SearchDynamicApplication {

    public static void main(String[] args) {
        SpringApplication.run(SearchDynamicApplication.class, args);
    }

}
