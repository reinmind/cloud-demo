package com.reinmind.controller;

import com.reinmind.entities.Customer;
import com.reinmind.entities.Order;
import com.reinmind.service.CustomerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
public class CustomerController {
    @Resource
    private CustomerService customerService;

    @GetMapping("/getAllCus")
    public List<Customer> getCustomers(){
        return customerService.findAllCustomer();
    }

    @PostMapping("/addCus")
    public Customer insertCustomer(@RequestBody Customer customer){
        return customerService.addCustomer(customer);
    }

    @PostMapping("/getCusByName")
    public List<Customer> getCustomerByName(@RequestBody Map<String,String> names){
        Customer cus = new Customer();
        cus.setFirstName(names.get("firstName"));
        cus.setLastName(names.get("lastName"));
        return customerService.getCusByName(cus);
    }


}
