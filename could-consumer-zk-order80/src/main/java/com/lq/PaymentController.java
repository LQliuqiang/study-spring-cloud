package com.lq;

import com.lq.entities.CommentResult;
import com.lq.entities.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * 使用zookeeper做服务注册中心
 */
@RestController
public class PaymentController {


    private static final String INVOKE_URL = "http://could-provider-zk-payment-service";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/getPayment")
    public Payment getPayment(){
        return restTemplate.getForObject(INVOKE_URL + "/provider/getPayment", Payment.class);
    }

}
