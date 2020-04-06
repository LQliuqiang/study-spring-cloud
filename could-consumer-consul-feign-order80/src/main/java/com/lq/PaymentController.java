package com.lq;

import cn.hutool.core.util.IdUtil;
import com.lq.entities.Payment;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@DefaultProperties(defaultFallback = "testHystrixGlobErrorHandler")
public class PaymentController {


    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/getPayment")
    public Payment getPayment() {
        return paymentFeignService.getPayment();
    }

    @GetMapping("/consumer/getPaymentTimeout")
    public Payment getPaymentTimeout() {
        return paymentFeignService.getPaymentTimeout();
    }

    @GetMapping("/consumer/testHystrix1")
    @HystrixCommand(fallbackMethod = "testHystrix1ErrorHandler")
    public String testHystrix1(int number) {
        int nb = 10 / number;
        return "testHystrix1";
    }

    public String testHystrix1ErrorHandler(int number) {
        return "testHystrix1ErrorHandler";
    }


    @GetMapping("/consumer/testHystrix2")
    @HystrixCommand
    public String testHystrix2(int number) {
        int nb = 10 / number;
        return "testHystrix2";
    }

    public String testHystrixGlobErrorHandler() {
        return "testHystrixGlobErrorHandler";
    }

    /****服务熔断****/

    @Resource
    private PaymentService paymentService;

    @GetMapping("/paymentCircuitBreaker/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") int id) {
        return paymentService.paymentCircuitBreaker(id);
    }


}
