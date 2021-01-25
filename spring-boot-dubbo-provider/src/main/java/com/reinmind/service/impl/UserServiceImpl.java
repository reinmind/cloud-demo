package com.reinmind.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.reinmind.service.IUserService;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author xiang.zhang
 */
@Service
public class UserServiceImpl implements IUserService {

    @Value("${dubbo.application.name}")
    private String serviceName;

    @Override
    public String getMessage(String name) {
        return serviceName + ":" + name;
    }
}
