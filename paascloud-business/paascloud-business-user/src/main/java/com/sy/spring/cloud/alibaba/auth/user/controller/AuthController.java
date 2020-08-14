package com.sy.spring.cloud.alibaba.auth.user.controller;


import com.sy.spring.cloud.alibaba.auth.user.domain.dto.AuthLoginDto;
import com.sy.spring.cloud.alibaba.auth.user.domain.dto.RegisterUserDto;
import com.sy.spring.cloud.alibaba.auth.user.domain.dto.UpdPasswordDto;
import com.sy.spring.cloud.alibaba.auth.user.domain.vo.UserLoginVo;
import com.sy.spring.cloud.alibaba.auth.user.service.SelfUserDetailService;
import com.sy.spring.cloud.alibaba.auth.user.service.UserInfoService;
import com.sy.spring.cloud.alibaba.provider.basic.utils.StringUtil;
import com.sy.spring.cloud.alibaba.provider.basic.web.RespBean;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @author ：sy
 * @date ：Created in 2020.3.29 10:47
 * @description: 针对用户登录
 */
@RestController
@RequestMapping("/userAuth")
@Api(tags = "用户登录管理")
public class AuthController {


    @Resource
    private SelfUserDetailService userDetailService;

    @Resource
    private UserInfoService userInfoService;



    @PostMapping("/login")
    @ApiOperation(value = "用户登陆",notes = "有两种方式： 1、使用帐号（邮箱或手机后）密码，2、使用手机号和验证码")
    public RespBean<UserLoginVo> login(@RequestBody AuthLoginDto authLoginVo){
        UserLoginVo userLoginVo ;
        if (!"".equals(authLoginVo.getMobile())&&authLoginVo.getMobile()!=null){
            if("".equals(authLoginVo.getCode())){
                return RespBean.fail("请求输入验证码");
            }
            userLoginVo = userDetailService.userLoginByCode(authLoginVo.getMobile(),authLoginVo.getCode());
            return RespBean.succeed("登陆成功",userLoginVo);
        }
        userLoginVo = userInfoService.userLoginByEvidence(authLoginVo);
        return RespBean.succeed("登陆成功",userLoginVo);
    }



    @GetMapping("/checkEmail")
    @ApiOperation(value = "校验手机号、邮箱、QQ是否被注册过",notes = "一个手机号、邮箱、QQ只能绑定一个帐号，所以需要校验是否被注册使用过,校验哪个传哪个")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "手机号",name = "mobile",paramType="query"),
            @ApiImplicitParam(value = "邮箱",name = "email",paramType="query"),
            @ApiImplicitParam(value = "QQ号",name = "qq",paramType="query"),
    })
    public RespBean checkAcc(String mobile,String email,String qq){
        String s = userInfoService.checkAcc(mobile,email,qq);
        if (s==null){
            return RespBean.succeed("未绑定");
        }
        return RespBean.fail("该信息已被使用");
    }

    @PostMapping("/register")
    @ApiOperation(value = "注册个人信息",notes = "注册的认证方式选择邮箱验证码")
    public RespBean testEmial(@RequestBody @Valid RegisterUserDto registerUserDto){
        UserLoginVo register = userDetailService.register(registerUserDto);
        return RespBean.succeed("注册成功",register);
    }



    @PostMapping("/logout")
    @ApiOperation(value = "注销登陆")
    public RespBean logout(){
        return null;
    }


    @GetMapping("/getMobileCode")
    @ApiOperation(value = "获取手机验证码",notes = "注册时获取手机验证码")
    @ApiImplicitParam(value = "手机号",paramType = "query",name = "mobile",required = true)
    public RespBean getMobileCode(String mobile){
        boolean b = StringUtil.matchMobile(mobile);
        if (!b){
            return RespBean.fail("请输入正确的手机号");
        }
        userDetailService.getMobileCode(mobile);
        return RespBean.succeed("验证码已发送");
    }

    @GetMapping("/getEmailCode")
    @ApiOperation(value = "获取邮箱验证码",notes = "注册时获取邮箱验证码")
    @ApiImplicitParam(value = "邮箱",paramType = "query",name = "email",required = true)
    public RespBean getEmailCode( String email){
        boolean b = StringUtil.matchEmail(email);
        if (!b){
            return RespBean.fail("请输入正确的邮箱");
        }
        userDetailService.getEmailCode(email);
        return RespBean.succeed("邮箱已发送");
    }



    @PostMapping("updPwd")
    @ApiOperation(value = "修改密码")
    public RespBean updPassword(@RequestBody UpdPasswordDto passwordDto){
        userInfoService.updPasswordByDto(passwordDto);
        return RespBean.succeed("修改成功");
    }



}
