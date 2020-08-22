package com.sy.spring.cloud.alibaba.generator.es.controller;

import com.sy.spring.cloud.alibaba.provider.api.dubbo.generator.es.UserInfoEsService;
import com.sy.spring.cloud.alibaba.provider.basic.domain.auth.UserInfo;
import com.sy.spring.cloud.alibaba.provider.basic.web.RespBean;
import io.swagger.annotations.Api;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author sy
 * @date: 2020/8/22 10:13
 * @description 测试控制层
 */
@RestController
@RequestMapping("/api")
@Api(tags = "测试")
public class TestController {


    @Resource
    private UserInfoEsService userInfoEsService;



    @GetMapping("/test")
    public RespBean sdf(){
        UserInfo userInfo = new UserInfo();
        userInfo.setId(765);
        userInfo.setUserName("测试");
        userInfo.setQq("234234234234");
        userInfoEsService.save(userInfo);


        userInfo.setId(47983);
        userInfo.setUserName("小明");
        userInfo.setQq("QQ号测试游戏地方");
        userInfoEsService.save(userInfo);


        userInfo.setId(473);
        userInfo.setUserName("测试");
        userInfo.setQq("斯蒂芬发共和国");
        userInfoEsService.save(userInfo);

        userInfo.setId(1690);
        userInfo.setUserName("斯蒂芬豆腐干");
        userInfo.setQq("234234234234");
        userInfoEsService.save(userInfo);

        return RespBean.succeed("成功");
    }

    @GetMapping("/getByKeyword")
    public RespBean<Page<UserInfo>> get(@RequestParam(value = "keyword") String keyword){
        Page<UserInfo> byKeyword = userInfoEsService.findByKeyword(keyword,0,10);
        return RespBean.succeed(byKeyword);
    }



}
