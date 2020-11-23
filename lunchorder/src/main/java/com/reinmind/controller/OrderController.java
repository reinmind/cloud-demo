package com.reinmind.controller;

import com.reinmind.entities.Order;
import com.reinmind.repository.OrderRepository;
import com.reinmind.service.OrderService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class OrderController {

    @Resource
    private OrderService orderService;
    @Resource
    private OrderRepository orderRepository;

    @GetMapping("/orderinserttest")
    public List<Order> orderList(){
        return orderService.insertTest();
    }

    @PostMapping("/singleInsert")
    public Order singleInsert(@RequestBody Order order){
        return orderService.singleInsert(order);
    }

    @GetMapping("/getAllOrders")
    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    @GetMapping("/getOrdersByCusFirstName")
    public List<Order> getOrdersByCusFirstName(@PathParam(value = "firstName")String firstName){
        return orderRepository.getOrderByCustomer_FirstName(firstName);
    }
}
