package com.reinmind.controller;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.reinmind.KafkaProvider;
import com.reinmind.constant.Dict;
import com.reinmind.service.ProviderService;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class ProviderController {
    @Resource
    private ProviderService providerService;

    @Resource
    private String demo;

    @GetMapping("/testKafka")
    public @ResponseBody Dict testKafka(@RequestParam String message){
        return providerService.sendMessage(message);
    }

    @GetMapping("/testBean")
    @Resource
    public @ResponseBody
    String testBean(String demo2){
        providerService.sendMessage(demo2);
        return providerService.sendMessage(demo).toString();
    }
}
