package com.joyin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author zx
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaMain {
    public static void main(String[] args) {
        SpringApplication.run(EurekaMain.class,args);
    }
}
