package com.reinmind.service;

import com.alibaba.fastjson.JSON;
import com.reinmind.entities.Customer;
import com.reinmind.service.interf.GreetingService;
import org.springframework.context.annotation.Bean;

/**
 * @author xiang.zhang
 */
public class GreetingServiceImpl implements GreetingService {
    @Override
    public String sayHi(String name) {
        return "GoodBye," + name;
    }

    public void jsonConvert(){
        Customer customer = new Customer();
        customer.setId("2");
        customer.setFirstName("zhang");
        customer.setLastName("xiang");
        customer.setPhoneNumber("17355482312");
        System.out.println(customer.toString());
        Customer customer1 = JSON.parseObject(customer.toString(),Customer.class);
        System.out.println(customer1);
        System.out.println("cus1 equals to cus2:" + customer1.equals(customer));
    }
}
