package com.reinmind.repository;

import com.reinmind.entities.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OrderRepository extends MongoRepository<Order,String> {
    public List<Order> getOrderByCustomer_FirstName(String firName);
}
