package com.sy.spring.cloud.alibaba.bus.rocketmq.controller;

import com.sy.spring.cloud.alibaba.bus.rocketmq.rocketmq.ProviderService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author sy
 * @date Created in 2020.6.2 21:37
 * @description 测试
 */
@RestController
@RequestMapping("/test")
@Api(tags = "测试类")
public class TestController {

    @Resource
    private ProviderService providerService;


    @GetMapping("/test")
    public void test(){
        providerService.send("hello rocket-mq");
    }




}
