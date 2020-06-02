package com.sy.spring.cloud.alibaba.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sy
 * @date Created in 2020.4.15 21:52
 * @description 测试controller
 */
@RestController
@RequestMapping("/test")
public class TestController {


    @GetMapping("test1")
    public Object test(){
        return "成功";
    }


}
