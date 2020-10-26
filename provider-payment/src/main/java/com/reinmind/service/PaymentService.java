package com.reinmind.service;

import com.reinmind.dao.PaymentDao;
import com.reinmind.entities.Payment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zx
 */

@Service
public class PaymentService {

    @Resource
    public PaymentDao paymentDao;

    public int create(Payment payment){
        return paymentDao.create(payment);
    }
    public Payment getPaymentById(Long id){
        return paymentDao.getPaymentById(id);
    }

}
