package com.reinmind.messagingrabbitmq;

import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

/**
 * rabbitmq消息接收
 *
 * @author zx
 * @date 2020/10/26
 */
@Component
public class Receiver {
    private CountDownLatch latch = new CountDownLatch(1);

    public void receiveMessage(String message){
        System.out.println("Received <" + message + ">");
        latch.countDown();
    }

    public CountDownLatch getLatch(){
        return latch;
    }
}
