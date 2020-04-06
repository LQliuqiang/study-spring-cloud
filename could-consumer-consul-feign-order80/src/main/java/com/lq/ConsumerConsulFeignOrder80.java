package com.lq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * hystrix做服务降级熔断限流 OpenFeign服务调用 consul服务注册中心
 */
@SpringBootApplication
//该注解用于consul或zookeeper做注册中心注册服务
@EnableDiscoveryClient
//开启openFeign
@EnableFeignClients
//开启feign与hystrix的结合使用
@EnableHystrix
//开启Hystrix中的熔断器，也可以在@HystrixCommand中开启；此处@EnableCircuitBreaker的另一个作用，配合Hystrix仪表盘监控使用
//@EnableCircuitBreaker
public class ConsumerConsulFeignOrder80 {

    public static void main(String[] args){
        SpringApplication.run(ConsumerConsulFeignOrder80.class, args);
    }

}
