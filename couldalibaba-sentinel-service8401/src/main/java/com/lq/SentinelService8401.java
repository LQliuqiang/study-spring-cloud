package com.lq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
//该注解用于nacos做注册中心注册服务
@EnableDiscoveryClient
//开启openFeign
@EnableFeignClients
public class SentinelService8401 {

    public static void main(String[] args){
        SpringApplication.run(SentinelService8401.class, args);
    }

}
