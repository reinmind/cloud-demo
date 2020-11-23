package com.reinmind.repository;

import com.reinmind.redis.Message;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MessageRepository extends MongoRepository<Message,String> {
}
