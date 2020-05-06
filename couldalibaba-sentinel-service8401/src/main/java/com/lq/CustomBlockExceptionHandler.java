package com.lq;

import org.springframework.web.bind.annotation.PathVariable;

public class CustomBlockExceptionHandler {

    public static String deal_testBlockExceptionHandler(@PathVariable("id")Long id,Throwable e){
        return "deal_testBlockExceptionHandler.......";
    }

    public static String deal_testSentinelHandler(@PathVariable("id")Long id,Throwable e){
        return "deal_testSentinelHandler.....exception.........";
    }

}
