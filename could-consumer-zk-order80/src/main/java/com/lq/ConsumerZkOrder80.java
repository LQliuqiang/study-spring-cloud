package com.lq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
//该注解用于consul或zookeeper做注册中心注册服务
@EnableDiscoveryClient
public class ConsumerZkOrder80 {

    public static void main(String[] args){
        SpringApplication.run(ConsumerZkOrder80.class, args);
    }

}
