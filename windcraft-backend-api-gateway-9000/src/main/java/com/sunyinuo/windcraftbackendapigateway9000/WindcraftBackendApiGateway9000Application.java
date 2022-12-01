package com.sunyinuo.windcraftbackendapigateway9000;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * ApiGateway
 * @author martin
 */
@SpringBootApplication
@EnableDiscoveryClient
public class WindcraftBackendApiGateway9000Application {

    public static void main(String[] args) {
        SpringApplication.run(WindcraftBackendApiGateway9000Application.class, args);
    }

}
