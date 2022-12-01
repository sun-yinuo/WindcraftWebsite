package com.sunyinuo.searchcomments;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SearchCommentsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SearchCommentsApplication.class, args);
    }

}
