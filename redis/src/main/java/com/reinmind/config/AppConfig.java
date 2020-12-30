package com.reinmind.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@Configuration

public class AppConfig {
    @Bean
   public JedisConnectionFactory jedisConnectionFactory(){
        RedisStandaloneConfiguration config = new RedisStandaloneConfiguration("127.0.0.1",6379);
        return new JedisConnectionFactory(config);
   }

}
