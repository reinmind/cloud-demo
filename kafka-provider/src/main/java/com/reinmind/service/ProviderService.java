package com.reinmind.service;

import com.reinmind.constant.Dict;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ProviderService {
    @Resource
    private KafkaTemplate<String,String> kafkaTemplate;

    public Dict sendMessage(String message){
        try {
            kafkaTemplate.send("kafka.hello",message);
        } catch (Exception e) {
            return Dict.FAILED;
        }
        return Dict.SUCCESS;
    }
}
