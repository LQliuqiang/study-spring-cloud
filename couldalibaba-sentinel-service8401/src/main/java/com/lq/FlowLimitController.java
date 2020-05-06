package com.lq;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlowLimitController {


    @GetMapping("/testA")
    public String testA() {
        return "------testA";
    }

    @GetMapping("/testB")
    public String testB() {
        return "------testB";
    }


    /**
     * 测试热点规则
     *
     * @param p1
     * @param p2
     * @return
     */
    @GetMapping("/testHotKeyRule")
    @SentinelResource(value = "testHotKeyRule", blockHandler = "deal_testHotKeyRule")
    public String testHotKeyRule(@RequestParam(value = "p1", required = false) String p1,
                                 @RequestParam(value = "p2", required = false) String p2) {
        return "------testHotKeyRule...LQ";
    }

    public String deal_testHotKeyRule(String p1, String p2, BlockException exception) {
        return "deal_testHotKeyRule.......";
    }

//    public String deal_testHotKeyRuleException(String p1, String p2, BlockException exception){
//        return "deal_testHotKeyRule.......";
//    }

    /**
     * 将兜底的超出sentinel配置规则的处理方法放置在单独一个类里
     */

    @GetMapping("/testBlockRuleHandler")
    @SentinelResource(value = "testBlockRuleHandler",
            blockHandlerClass = CustomBlockRuleHandler.class,
            blockHandler = "deal_testBlockRuleHandler")
    public String testBlockRuleHandler() {
        return "------testBlockRuleHandler...LQ";
    }

    /**
     * 将兜底的异常处理方法放置在单独一个类里（兜底的异常处理与兜底的规则处理方法是两码事）
     */
    @GetMapping("/testBlockExceptionHandler/{id}")
    @SentinelResource(value = "testBlockExceptionHandler",
            fallbackClass = CustomBlockExceptionHandler.class,
            fallback = "deal_testBlockExceptionHandler")
    public String testBlockExceptionHandler(@PathVariable("id") Long id) {
        if (id == 4) {
            throw new IllegalArgumentException("非法参数异常");
        } else if (id > 4) {
            throw new NullPointerException("空指针异常");
        }
        return "------testBlockExceptionHandler...LQ";
    }


    /**
     * 将兜底的异常处理与兜底的超出sentinel配置规则的处理方法
     */
    @GetMapping("/testSentinelHandler/{id}")
    @SentinelResource(value = "testSentinelHandler",
            blockHandlerClass = CustomBlockRuleHandler.class,
            blockHandler = "deal_testSentinelHandler",
            fallbackClass = CustomBlockExceptionHandler.class,
            fallback = "deal_testSentinelHandler")
    public String testSentinelHandler(@PathVariable("id") Long id) {
        if (id == 4) {
            throw new IllegalArgumentException("非法参数异常");
        } else if (id > 4) {
            throw new NullPointerException("空指针异常");
        }
        return "------testSentinelHandler...LQ";
    }

}
