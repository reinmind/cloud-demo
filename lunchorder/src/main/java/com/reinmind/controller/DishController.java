package com.reinmind.controller;

import com.reinmind.entities.Dish;
import com.reinmind.repository.DishRepository;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class DishController {


    @Resource
    DishRepository dishRepository;
    @PostMapping("/insertDish")
    public @ResponseBody
    String insertDish(@RequestBody @Validated Dish dish,BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            List<String> msg = new ArrayList<>();
            for(ObjectError objectError : bindingResult.getAllErrors()){
                msg.add(objectError.getDefaultMessage());
            }
            return msg.toString();
        }
        return dishRepository.insert(dish).toString();
    }
}
