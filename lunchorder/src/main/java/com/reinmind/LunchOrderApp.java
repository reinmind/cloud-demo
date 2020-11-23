package com.reinmind;

import com.reinmind.redis.Receiver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.StringRedisTemplate;


/**
 * LunchOrder启动类
 */
@SpringBootApplication
public class LunchOrderApp {
    private static final Logger logger = LoggerFactory.getLogger(LunchOrderApp.class);
    public static void main(String[] args) throws InterruptedException {
        ApplicationContext context = SpringApplication.run(LunchOrderApp.class,args);
        StringRedisTemplate template = context.getBean(StringRedisTemplate.class);
        new Thread(() ->{
            for(int i = 0; i < 10; ++i){
                logger.info("Sending:{}\n",i);
                template.convertAndSend("chat1","receive Thead 1: hello!.");
                try {
                    Thread.sleep(500L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(() -> {
            for(int i = 0; i < 10; ++i){
                logger.info("Sending:{}\n",i);
                template.convertAndSend("chat2","receive Thead 2: world!.");
            }
        }).start();
    }
}
