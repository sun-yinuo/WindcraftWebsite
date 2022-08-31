package com.sunyinuo.windcraftbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * 主类
 * @author martin
 */
@SpringBootApplication
@EnableCaching
public class WindcraftBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(WindcraftBackendApplication.class, args);
    }

}
