package com.joyin.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * 测试服务
 *
 * @author zx
 * @date 2020/10/21
 */
public class IndexService {

    @Bean
    @Qualifier("hello")
    public String hello(){
        return "helloworld";
    }
}
