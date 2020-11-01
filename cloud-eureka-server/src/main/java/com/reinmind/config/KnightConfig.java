package com.reinmind.config;

import com.reinmind.entity.Knight;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 装配配置
 *
 * @author zx
 * @date 2020/10/29
 */
@Configuration
public class KnightConfig {
    @Bean
    public Knight knight(){
        return () -> {
            return "Hello Knight";
        };
    }
}
