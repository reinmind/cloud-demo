package com.reinmind.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@Data
public class Dish {
    @Id
    private String id;
    private String name;
    private double price;
}
