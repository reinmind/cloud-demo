package com.joyin.dao;

import com.joyin.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author zx
 */

@Mapper
public interface PaymentDao {
    /**
     * create new payment information
     * @param payment
     * @return the number of insertion successfully
     *
     */
    public int create(Payment payment);

    /**
     * retrieve payment
     * @param id
     * @return
     */
    public Payment getPaymentById(Long id);
}
