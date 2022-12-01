package com.sunyinuo.bancrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BanCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(BanCrudApplication.class, args);
    }

}
