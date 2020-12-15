package com.reinmind.controller;

import com.reinmind.entities.RedisObject;
import com.reinmind.repository.RedisObjectRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class CommonController {

    private final Logger logger = LoggerFactory.getLogger(CommonController.class);

    @Resource
    private RedisObjectRepository redisObjectRepository;

    @PostMapping("/put")

    public @ResponseBody RedisObject put(@RequestBody RedisObject redisObject){
       return redisObjectRepository.save(redisObject);
    }

    @GetMapping("/get")
    public @ResponseBody Iterable<RedisObject> get(){
        return redisObjectRepository.findAll();
    }

}
