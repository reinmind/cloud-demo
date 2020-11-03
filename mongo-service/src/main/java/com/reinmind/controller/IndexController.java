package com.reinmind.controller;

import com.reinmind.MongoService;
import com.reinmind.entity.Customer;
import com.reinmind.mongo.CustomerRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 首页控制器
 *
 * @author zx
 * @date 2020/10/16
 */
@Controller
public class IndexController {
    @Resource
    private CustomerRepository customerRepository;
    @RequestMapping("/")
    public @ResponseBody String index(){
        return "index";
    }

    @GetMapping("/getCustomer")
    public @ResponseBody Customer getByFirstName(@RequestParam String firstName){
        return customerRepository.findByFirstName(firstName);
    }
}
