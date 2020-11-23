package com.reinmind.redis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

@Configuration
public class RedisConfig {
    /**
     * 容器当中设置了连接工厂和监听适配器，接受特定通道的消息，
     * 不论是发送消息模板还是接受消息通道都依赖于连接工厂
     * @param redisConnectionFactory
     * @param listenerAdapter
     * @return
     */
    @Bean
    RedisMessageListenerContainer container(RedisConnectionFactory redisConnectionFactory, MessageListenerAdapter listenerAdapter){
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(redisConnectionFactory);
        container.addMessageListener(listenerAdapter,new PatternTopic("chat1"));
        container.addMessageListener(listenerAdapter,new PatternTopic("chat2"));
       return container;
    }

    /**
     * 监听器适配器，依赖接收器模板，接收器是实际的响应者
     * @param receiver
     * @return
     */
    @Bean("listenerAdapter2")
    MessageListenerAdapter listenerAdapter(Receiver receiver){
        return new MessageListenerAdapter(receiver,"getMessage");
    }

    @Bean("listenerAdapter")
    MessageListenerAdapter listenerAdapter2(Receiver receiver){
        return new MessageListenerAdapter(receiver,"saveMessage");
    }

    @Bean
    Receiver receiver(){
        return new Receiver();
    }

    /**
     * redis连接工厂
     * @param connectionFactory
     * @return
     */
    @Bean
    StringRedisTemplate template(RedisConnectionFactory connectionFactory){
        return new StringRedisTemplate(connectionFactory);
    }
}
