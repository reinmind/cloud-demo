package com.reinmind.redis;

import com.reinmind.repository.MessageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class Receiver {

    private static final Logger logger = LoggerFactory.getLogger(Receiver.class);

    @Autowired
    private MessageRepository messageRepository;


    public void getMessage(String message){
        logger.info("redis:{}",message);
    }
    public void saveMessage(String message){
        Message m = new Message();
        m.setMessage(message);
        messageRepository.save(m);
    }
}
