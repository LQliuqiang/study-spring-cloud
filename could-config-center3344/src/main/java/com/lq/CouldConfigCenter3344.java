package com.lq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * 本地通过 http://localhost:3344/master/config-dev.yml 访问配置git仓库下的配置文件信息
 *
 * 由于整合了bus消息总线，所以以服务配置中心的服务为起点，如果git上的配置文件修改了，那么此服务会通过消息广播的形式，全局通知其它微服务，
 * 配置文件修改了，那么触发此事件，可以通过post请求：http://localhost:3344/actuator/bus-refresh
 *
 * 扩展：定点通知，不通知所有的服务，通知执行的服务： http://localhost:3344/actuator/bus-refresh/微服务名称:微服务端口号
 */
@SpringBootApplication
//开启服务配置中心服务
@EnableConfigServer
//该注解用于consul或zookeeper做注册中心注册服务
@EnableDiscoveryClient
public class CouldConfigCenter3344 {

    public static void main(String[] args) {
        SpringApplication.run(CouldConfigCenter3344.class,args);
    }

}
