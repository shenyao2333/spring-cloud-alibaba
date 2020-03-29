package com.sy.spring.cloud.alibaba.auth.user.controller;


import com.sy.spring.cloud.alibaba.module.web.RespBean;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：sy
 * @date ：Created in 2020.3.29 10:47
 * @description: 针对用户登录
 */
@RestController
@RequestMapping("/user")
@Api(tags = "用户登录管理")
public class AuthController {



    @PostMapping("/login")
    public RespBean login(@RequestBody AuthLoginVo authLoginVo){

        return null;
    }

    @PostMapping("/register")
    public RespBean register(){
        return null;
    }


    @PostMapping("/logout")
    public RespBean logout(){
        return null;
    }


}
