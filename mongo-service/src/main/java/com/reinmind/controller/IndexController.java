package com.reinmind.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 首页控制器
 *
 * @author zx
 * @date 2020/10/16
 */
@Controller
public class IndexController {

    @RequestMapping("index")
    public @ResponseBody String index(){
        return "index";
    }
}
