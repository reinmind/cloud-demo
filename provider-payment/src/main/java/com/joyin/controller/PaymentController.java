package com.joyin.controller;

import com.joyin.entities.CommonResult;
import com.joyin.entities.Payment;
import com.joyin.service.PaymentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author zx
 */

@Controller
public class PaymentController {

    @Resource
    private PaymentService paymentService;


    @PostMapping("/payment/create")
    @ResponseBody
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        if(result > 0 ){
            return new CommonResult(200,"插入数据成功",result);
        }
        else
        {
            return new CommonResult(500,"插入数据失败");
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    @ResponseBody
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        if(payment != null){
            return new CommonResult(200,"查询成功",payment);
        }
        else{
            return new CommonResult(500,"查询失败");
        }
    }
}
