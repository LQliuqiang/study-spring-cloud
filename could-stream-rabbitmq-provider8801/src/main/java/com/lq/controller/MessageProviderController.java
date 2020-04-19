package com.lq.controller;

import com.lq.service.IMessageProvider;
import org.springframework.integration.core.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class MessageProviderController {

    @Resource
    private IMessageProvider messageProvider;

    @GetMapping("/sendMsg")
    public String sendMsg(){
        return  messageProvider.send()?"success":"fail";
    }

}
