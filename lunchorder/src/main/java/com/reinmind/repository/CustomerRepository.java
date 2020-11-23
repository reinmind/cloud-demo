package com.reinmind.repository;

import com.reinmind.entities.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {
    List<Customer> findCustomerByFirstNameAndLastName(String firstName,String lastName);
}
