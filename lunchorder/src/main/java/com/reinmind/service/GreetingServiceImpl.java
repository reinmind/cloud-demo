package com.reinmind.service;

import com.reinmind.service.interf.GreetingService;

public class GreetingServiceImpl implements GreetingService {
    @Override
    public String sayHi(String name) {
        return "GoodBye," + name;
    }
}
