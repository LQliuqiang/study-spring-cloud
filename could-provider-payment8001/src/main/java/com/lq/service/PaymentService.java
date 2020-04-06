package com.lq.service;

import com.lq.entities.Payment;

public interface PaymentService {

    int create(Payment payment);


    Payment getPaymentById(Long id);

}
