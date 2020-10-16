package com.reinmind;

import com.reinmind.entity.Customer;
import com.reinmind.mongo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * MongoService启动类
 *
 * @author zx
 * @date 2020/10/16
 */
@SpringBootApplication
public class MongoService implements CommandLineRunner {
    @Autowired
    private CustomerRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(MongoService.class,args);
    }

    @Override
    public void run(String ... args){
        repository.deleteAll();

        // save a couple of customers
        repository.save(new Customer("Alice","Smith"));
        repository.save(new Customer("Bob","Smith"));

        // fetch all customers
        for(Customer customer: repository.findAll()){
            System.out.println(customer);
        }
    }
}
