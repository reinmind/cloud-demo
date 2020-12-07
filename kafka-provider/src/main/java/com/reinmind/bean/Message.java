package com.reinmind.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Message {

    @Bean("demo")
    public String demo(){
        return "This is demo";
    }

    @Bean
    public String demo2(){
        return "This is demo2";
    }
}
