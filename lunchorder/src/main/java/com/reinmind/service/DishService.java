package com.reinmind.service;

import com.reinmind.entities.Dish;
import com.reinmind.repository.DishRepository;

import javax.annotation.Resource;

public class DishService {
    @Resource
    private DishRepository dishRepository;

    public Dish addDish(Dish dish){
        return dishRepository.insert(dish);
    }

}
