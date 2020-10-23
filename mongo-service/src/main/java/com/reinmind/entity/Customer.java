package com.reinmind.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Repository;

/**
 * 用户实体类
 *
 * @author zx
 * @date 2020/10/16
 */
@Data
@Repository
public class Customer {
    @Id
    private String id;

    private String firstName;
    private String lastName;
    public Customer(){}
    public Customer(String firstName,String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
