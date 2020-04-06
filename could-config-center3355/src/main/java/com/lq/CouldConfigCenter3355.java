package com.lq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 本地通过访问http://localhost:3344/master/config-dev.yml 访问配置文件信息
 * 问题：如果git上配置文件修改了，本地3355却读取不到最新修改的配置信息
 *      解决：1.在配置本地bootstrap.yml配置文件中添加
 *      management.endpoints.web.exposure.include = "*"
 *      2.在controller上添加@RefreshScope注解
 *      3.发送一个post请求： http://localhost:3355/actuator/refresh
 */
@SpringBootApplication
//该注解用于consul或zookeeper做注册中心注册服务
@EnableDiscoveryClient
public class CouldConfigCenter3355 {

    public static void main(String[] args) {
        SpringApplication.run(CouldConfigCenter3355.class,args);
    }

}
