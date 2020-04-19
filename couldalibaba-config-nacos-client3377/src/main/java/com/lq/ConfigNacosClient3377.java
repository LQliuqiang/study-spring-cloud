package com.lq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
//该注解用于nacos做注册中心注册服务
@EnableDiscoveryClient
public class ConfigNacosClient3377 {

    public static void main(String[] args){
        SpringApplication.run(ConfigNacosClient3377.class, args);
    }

}
