package com.reinmind.mongo;

import com.reinmind.entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author zx
 */
public interface CustomerRepository extends MongoRepository<Customer,String> {
     Customer findByName(String firstName);
     List<Customer> findByLastName(String lastName);
}
