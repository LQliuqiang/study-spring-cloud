package com.lq.mapper;

import com.lq.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentMapper {

    int create(Payment payment);


    Payment getPaymentById(@Param("id") Long id);
}
