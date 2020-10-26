package com.reinmind.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;


/**
 * @author zx
 */
@Controller
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "index";
    }

    @RequestMapping("/hahaha")
    @ResponseBody
    public String test(Model model){
        Map<String,Object> ttt = model.asMap();
        return "hahaha";
    }


}
