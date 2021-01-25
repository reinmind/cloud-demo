package com.reinmind.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.List;

/**
 * @author xiang.zhang
 */
@Data
public class Order {
    @Id
    private String id;
    private List<Dish> dishList;
    private Date date;
    private double price;
    private Customer customer;
}
