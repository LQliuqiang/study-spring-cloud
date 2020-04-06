package com.lq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
//该注解用于consul或zookeeper做注册中心注册服务
@EnableDiscoveryClient
public class ProviderConsulPayment8001 {

    public static void main(String[] args){
        SpringApplication.run(ProviderConsulPayment8001.class, args);
    }

}
