package com.lq;

import com.lq.entities.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class PaymentController {


    @GetMapping("/provider/getPayment")
    public Payment getPayment(){
        return new Payment(8002L, UUID.randomUUID().toString()+"--8002");
    }

    @GetMapping("/provider/getPaymentTimeout")
    public Payment getPaymentTimeout(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new Payment(8002L, UUID.randomUUID().toString()+"--8001");
    }
}
