package com.lq.feign;

import com.lq.entities.Payment;
import org.springframework.stereotype.Component;

@Component
public class PaymentFallBackService implements PaymentFeignService {
    @Override
    public Payment getPayment() {
        return new Payment(80L, "PaymentFallBackService.......getPayment");
    }

    @Override
    public Payment getPaymentTimeout() {
        return new Payment(80L, "PaymentFallBackService.......getPaymentTimeout");
    }
}
