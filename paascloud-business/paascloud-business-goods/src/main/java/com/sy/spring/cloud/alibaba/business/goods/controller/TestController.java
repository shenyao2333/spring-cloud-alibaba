package com.sy.spring.cloud.alibaba.business.goods.controller;


import com.sy.spring.cloud.alibaba.provider.api.feign.businesssocial.TestFeign;
import com.sy.spring.cloud.alibaba.provider.basic.web.RespBean;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sy
 * @date Created in 2020.7.12 16:38
 * @description 测试controller层
 */
@RestController
@RequestMapping("/api")
@Api(tags = "公用接口")
public class TestController {


    @Autowired
    private TestFeign testFeign;


    @GetMapping("/test")
    public RespBean testFeign(String name){
        RespBean respBean = testFeign.testFeign(name);
        return respBean;
    }


}
