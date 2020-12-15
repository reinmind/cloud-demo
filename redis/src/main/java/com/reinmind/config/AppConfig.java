package com.reinmind.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@Configuration
@EnableRedisRepositories
public class AppConfig {

//    @Bean
//    public RedisConnectionFactory connectionFactory(){
//        return new JedisConnectionFactory();
//    }
//    @Bean
//    public RedisTemplate<RedisObject,String> redisTemplate(){
//        return new RedisTemplate<>();
//    }
}
