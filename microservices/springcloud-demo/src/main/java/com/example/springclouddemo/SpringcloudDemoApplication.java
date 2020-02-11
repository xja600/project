package com.example.springclouddemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 *
 */

@SpringBootApplication
@EnableEurekaServer
public class SpringcloudDemoApplication {

/**
 * @author xinjunan
 * @date 2019/6/29 18:53
 * @version V1.0
 */

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudDemoApplication.class, args);
    }
}