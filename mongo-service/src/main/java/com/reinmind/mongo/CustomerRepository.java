package com.reinmind.mongo;

import com.reinmind.entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zx
 */
@Repository
public interface CustomerRepository extends MongoRepository<Customer,String> {
    Customer findByFirstName(String firstName);
    List<Customer> findByLastName(String lastName);
}
