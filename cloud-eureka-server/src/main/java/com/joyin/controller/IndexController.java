package com.joyin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 测试主页
 *
 * @author zx
 * @date 2020/10/21
 */
@Controller
public class IndexController {

    private static final String hello = "helloworld";

    @RequestMapping("hello")
    @Autowired
    public @ResponseBody String hello(){
        return hello;
    }
}
