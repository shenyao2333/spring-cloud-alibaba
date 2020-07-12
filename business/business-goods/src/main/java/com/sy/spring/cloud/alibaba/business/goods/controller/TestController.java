package com.sy.spring.cloud.alibaba.business.goods.controller;


import com.sy.spring.cloud.alibaba.bus.api.feign.TestFeign;
import com.sy.spring.cloud.alibaba.module.web.RespBean;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author sy
 * @date Created in 2020.7.12 16:38
 * @description 测试controller层
 */
@RestController
@RequestMapping("/api")
@Api(tags = "公用接口")
public class TestController {


    @Resource
    private TestFeign testFeign;


    @GetMapping("/testFeign")
    public RespBean testFeign(String name){
        RespBean respBean = testFeign.testFeign(name);
        return respBean;
    }


}
