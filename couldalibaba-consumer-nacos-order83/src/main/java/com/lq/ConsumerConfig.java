package com.lq;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConsumerConfig {

    @Bean
    @LoadBalanced  //Spring Cloud Ribbon是基于Netflix Ribbon实现的一套客户端       负载均衡的工具。
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    /**
     * 切换Robin负载均衡的算法，默认是RoundRobinRule轮询算法
     * @return
     */
//    @Bean
//    public IRule myRule()
//    {
//        //return new RoundRobinRule();
//        //return new RandomRule();//达到的目的，用我们重新选择的随机算法替代默认的轮询。
//        return new RetryRule(); //默认先是轮询算法，如果有个服务挂了，那么它会重试其它的服务
//    }

}
