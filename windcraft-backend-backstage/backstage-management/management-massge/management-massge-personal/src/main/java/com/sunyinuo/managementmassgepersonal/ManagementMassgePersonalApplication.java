package com.sunyinuo.managementmassgepersonal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author martin
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ManagementMassgePersonalApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManagementMassgePersonalApplication.class, args);
    }

}
