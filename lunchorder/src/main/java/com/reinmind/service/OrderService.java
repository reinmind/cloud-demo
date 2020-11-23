package com.reinmind.service;

import com.reinmind.entities.Customer;
import com.reinmind.entities.Order;
import com.reinmind.repository.CustomerRepository;
import com.reinmind.repository.OrderRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    @Resource
    private OrderRepository orderRepository;

    @Resource
    private CustomerRepository customerRepository;

    public List<Order> insertTest(){
        List<Customer> customers = customerRepository.findCustomerByFirstNameAndLastName("Sam","Smith");
        List<Order> orders = new ArrayList<>();
        for(Customer customer: customers){
            Order order = new Order();
            order.setCustomer(customer);
            orders.add(order);
        }
        return orderRepository.insert(orders);
    }

    public Order singleInsert(Order order){
        return orderRepository.insert(order);
    }
}
