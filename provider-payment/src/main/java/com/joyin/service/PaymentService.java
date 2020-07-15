package com.joyin.service;

import com.joyin.dao.PaymentDao;
import com.joyin.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zx
 */
@Service
public class PaymentService {

    @Autowired
    public PaymentDao paymentDao;

    public int create(Payment payment){
        return paymentDao.create(payment);
    }
    public Payment getPaymentById(Long id){
        return paymentDao.getPaymentById(id);
    }

}
