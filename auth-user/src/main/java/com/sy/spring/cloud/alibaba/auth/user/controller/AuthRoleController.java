package com.sy.spring.cloud.alibaba.auth.user.controller;

import com.sy.spring.cloud.alibaba.module.web.RespBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sy
 * Date: 2020/4/3 17:44
 * @Description
 */
@RestController
@RequestMapping("/role")
@Api(tags = "用户权限管理")
public class AuthRoleController  {


    @GetMapping("/addRole")
    @ApiOperation(value = "添加用户权限")
    public Object test(){
        return RespBean.succeed("成功",123);
    }

}
