package com.sy.spring.cloud.alibaba.auth.user.controller;


import com.sy.spring.cloud.alibaba.auth.user.domain.dto.AuthLoginVo;
import com.sy.spring.cloud.alibaba.auth.user.service.UserInfoService;
import com.sy.spring.cloud.alibaba.module.domain.auth.UserInfo;
import com.sy.spring.cloud.alibaba.module.web.GrabException;
import com.sy.spring.cloud.alibaba.module.web.RespBean;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author ：sy
 * @date ：Created in 2020.3.29 10:47
 * @description: 针对用户登录
 */
@RestController
@RequestMapping("/user")
@Api(tags = "用户登录管理")
public class AuthController {


    @Resource
    private UserInfoService userInfoService;



    @PostMapping("/login")
    public RespBean login(@RequestBody AuthLoginVo authLoginVo){

        return null;
    }

    @PostMapping("/register")
    public RespBean<UserInfo> register(Long i){
        if (i<0){
            throw  new GrabException(-99,"错误测试");
        }
        if (i>9){
            String s="23e";
            long l = Long.parseLong(s);
        }
        UserInfo userInfo = userInfoService.selectByPrimaryKey(i);
        return RespBean.succeed(userInfo);
    }


    @PostMapping("/logout")
    public RespBean logout(){
        return null;
    }


}
