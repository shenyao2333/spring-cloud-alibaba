package com.sy.spring.cloud.alibaba.business.user.controller;

import com.sy.spring.cloud.alibaba.business.user.domain.dto.UpdUserInfoDto;
import com.sy.spring.cloud.alibaba.business.user.service.UserInfoService;
import com.sy.spring.cloud.alibaba.provider.basic.web.RespBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @author sy
 * @date Created in 2020.5.30 21:11
 * @description 用户信息管理
 */
@RestController
@RequestMapping("/userInfo")
@Api(tags = "用户信息管理")
public class UserInfoController {


    @Resource
    private UserInfoService userInfoService;


    @PostMapping("/updUserInfo")
    @ApiOperation(value = "修改用户信息")
    public RespBean logout(@RequestBody @Valid UpdUserInfoDto userInfoDto){
        int i = userInfoService.updUserByDto(userInfoDto);
        return RespBean.succeed("修改成功");
    }






}
