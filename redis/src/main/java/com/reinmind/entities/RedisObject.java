package com.reinmind.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("redisObject")
public class RedisObject {
    @Id
    private String key;
    private String value;

    public String getKey() {
        return key;
    }

    @Override
    public String toString() {
        return "RedisObject{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
