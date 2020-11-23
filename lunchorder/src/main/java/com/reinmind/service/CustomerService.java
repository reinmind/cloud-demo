package com.reinmind.service;

import com.reinmind.entities.Customer;
import com.reinmind.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CustomerService {

    @Resource
    private CustomerRepository customerRepository;

    public List<Customer> findAllCustomer(){
        return customerRepository.findAll();
    }

    public Customer addCustomer(Customer customer){
        return customerRepository.insert(customer);
    }

    public List<Customer> getCusByName(Customer cus){
        return customerRepository.findCustomerByFirstNameAndLastName(cus.getFirstName(),cus.getLastName());
    }
}
