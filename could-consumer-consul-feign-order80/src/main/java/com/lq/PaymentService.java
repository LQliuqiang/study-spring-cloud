package com.lq;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    /****服务熔断****/

    //在10秒钟之内有10次请求访问，且失败率达到60%，则跳闸
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallBack",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),//是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),//请求次数(不设置，也有默认值)
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//时间限制(不设置，也有默认值)
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60")//失败率达到多少后跳闸(不设置，也有默认值)
    })
    public String paymentCircuitBreaker(int id) {
        if (id < 0) {
            throw new RuntimeException("*******id不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return "调用成功，流水号:" + serialNumber;
    }

    public String paymentCircuitBreaker_fallBack(int id) {
        return "id不能为负数，请稍后重试:"+id;
    }

}
