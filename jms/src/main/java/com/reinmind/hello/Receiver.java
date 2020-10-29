package com.reinmind.hello;

import org.springframework.stereotype.Component;

/**
 * 接收器
 *
 * @author zx
 * @date 2020/10/26
 */
@Component
public class Receiver {
    public void receiveMessage(Email email){
        System.out.println("Received <" + email + ">");
    }
}
