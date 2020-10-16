package com.joyin.controller;

import com.joyin.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zx
 */
@Controller
@RequestMapping("/json")
public class JSONController {
    @RequestMapping("/user")
    @ResponseBody
    public User getUser(){
        return new User(1,"Jason");
    }

    @RequestMapping("/userList")
    @ResponseBody
    public List<User> getList(){
        User user1 = new User(1,"Jason");
        User user2 = new User(2,"Tom");
        List<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);
        return list;
    }

    @RequestMapping("userMap")
    @ResponseBody
    public Map<String,User> getUserMap(){
        Map<String,User> map = new HashMap<>();
        map.put("Jason",null);
        map.put("Tom",new User(2,null));
        return map;
    }

}
