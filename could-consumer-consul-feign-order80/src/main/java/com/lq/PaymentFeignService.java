package com.lq;

import com.lq.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;


@Component
//value 需要调用那个微服务在微服务注册中心中服务名称 fallback:如果方法调用异常(服务端超时，宕机等)，则会让PaymentFallBackService处理返回
@FeignClient(value = "could-provider-consul-payment-service",fallback = PaymentFallBackService.class)
public interface PaymentFeignService {

    @GetMapping("/provider/getPayment")
    Payment getPayment();

    @GetMapping("/provider/getPaymentTimeout")
    Payment getPaymentTimeout();
}
