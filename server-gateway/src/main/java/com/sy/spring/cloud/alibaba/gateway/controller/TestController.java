package com.sy.spring.cloud.alibaba.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author sy
 * @date Created in 2020.4.15 21:52
 * @description 测试controller
 */
@RestController
@RequestMapping("/test")
public class TestController {


  /*  @Resource
    private RedisUtil redisUtil;*/



    @GetMapping("test1")
    public Object test(){
        return "成功";
    }

    /*@GetMapping("test2")
    public Object sd(){
        return redisUtil.set("ss","23",12);
    }*/




}
