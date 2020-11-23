package com.reinmind.redis;


import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Message {
    private String message;
}
