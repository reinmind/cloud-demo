package com.reinmind;

import com.alibaba.dubbo.config.annotation.Reference;
import com.reinmind.service.IUserService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author xiang.zhang
 */
@SpringBootApplication
public class ConsumerApp {
    @Reference(url = "dubbo://192.168.2.1:20880/com.reinmind.service.IUserService")
    private IUserService userService;

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApp.class,args);
    }


    @Bean
    ApplicationRunner applicationRunner(){
        return args -> {
            System.out.println(userService.getMessage("Jason"));
        };
    }
}
