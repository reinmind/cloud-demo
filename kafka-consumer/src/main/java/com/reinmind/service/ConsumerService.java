package com.reinmind.service;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class ConsumerService {

    private final AtomicLong counter;

    private static final Logger logger = LoggerFactory.getLogger(ConsumerService.class);

    @KafkaListener(groupId = "com.reinmind",topics="kafka.hello")
    public void handle(String string, ConsumerRecord<String,String> record){

        logger.debug("Record from {} with timestamp {}", record.partition(),record.timestamp());
        logger.info("The {}th message:{}",counter.getAndIncrement(),record.value());
    }

    ConsumerService(){
        this.counter = new AtomicLong();
    }
}
