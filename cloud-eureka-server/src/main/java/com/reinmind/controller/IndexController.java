package com.reinmind.controller;

import com.reinmind.entity.User;
import net.minidev.json.JSONObject;
import net.minidev.json.JSONUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.concurrent.atomic.AtomicLong;

@Controller
public class IndexController {
    private static final AtomicLong COUNTER = new AtomicLong();
    @RequestMapping("hello")
    public @ResponseBody Object hello(@RequestParam String name){
        String id = ""+COUNTER.incrementAndGet();
        User user = new User();
        user.setId(id);
        user.setName(name);
        return JSONUtil.convertToStrict(user,User.class);
    }
}
