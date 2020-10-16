package com.joyin.controller;

import com.joyin.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
