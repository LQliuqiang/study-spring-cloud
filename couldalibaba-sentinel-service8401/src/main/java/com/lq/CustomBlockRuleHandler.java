package com.lq;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.PathVariable;

public class CustomBlockRuleHandler {

    public static String deal_testBlockRuleHandler(BlockException exception){
        return "deal_testBlockRuleHandler.......";
    }

    public static String deal_testSentinelHandler(@PathVariable("id")Long id, BlockException exception){
        return "deal_testSentinelHandler.......rule..........";
    }


}
