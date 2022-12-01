package com.sunyinuo.searchglobal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SearchGlobalApplication {

    public static void main(String[] args) {
        SpringApplication.run(SearchGlobalApplication.class, args);
    }

}
