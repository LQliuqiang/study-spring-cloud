package com.lq.feign;

import com.lq.entities.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class FeignSentinelController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/sentinel/getPayment")
    public Payment getPayment() {
        return paymentFeignService.getPayment();
    }

    @GetMapping("/consumer/sentinel/getPaymentTimeout")
    public Payment getPaymentTimeout() {
        return paymentFeignService.getPaymentTimeout();
    }

}
