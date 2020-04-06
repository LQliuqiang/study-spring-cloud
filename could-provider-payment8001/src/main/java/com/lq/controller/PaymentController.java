package com.lq.controller;

import com.lq.entities.CommentResult;
import com.lq.entities.Payment;
import com.lq.service.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class PaymentController {

    @Resource
    private PaymentService paymentService;


    @PostMapping(value = "insertPayment", consumes = "application/json", produces = "application/json")
    public CommentResult<Payment> insertPayment(@RequestBody Payment payment){
        int i = paymentService.create(payment);
        return i>0 ? new CommentResult<>(200,"success",payment):new CommentResult<>(240,"fail");
    }

    @GetMapping("getPaymentById")
    public CommentResult<Payment> getPaymentById(Long id){
        Payment payment = paymentService.getPaymentById(id);
        return new CommentResult<>(200,"success",payment);
    }

}
