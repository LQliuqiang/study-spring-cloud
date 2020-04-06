package com.lq;

import com.lq.entities.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class PaymentController {


    @GetMapping("/provider/getPayment")
    public Payment getPayment(){
        return new Payment(1L, UUID.randomUUID().toString());
    }

}
