package com.sy.spring.cloud.alibaba.generator.message.controller;

import com.sy.spring.cloud.alibaba.generator.message.rocketmq.ProviderService;
import com.sy.spring.cloud.alibaba.provider.basic.web.RespBean;
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
    public RespBean test(){
        providerService.send("hello rocket-mq");
        return RespBean.succeed();
    }




}
