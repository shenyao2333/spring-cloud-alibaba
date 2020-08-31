package com.sy.spring.cloud.alibaba.business.user.controller;


import com.sy.spring.cloud.alibaba.business.user.domain.dto.AuthLoginDto;
import com.sy.spring.cloud.alibaba.business.user.domain.dto.RegisterUserDto;
import com.sy.spring.cloud.alibaba.business.user.domain.dto.UpdPasswordDto;
import com.sy.spring.cloud.alibaba.business.user.domain.vo.UserLoginVo;
import com.sy.spring.cloud.alibaba.business.user.service.SelfUserDetailService;
import com.sy.spring.cloud.alibaba.business.user.service.UserInfoService;
import com.sy.spring.cloud.alibaba.provider.api.dubbo.generator.es.UserInfoEsService;
import com.sy.spring.cloud.alibaba.provider.basic.domain.auth.UserInfo;
import com.sy.spring.cloud.alibaba.provider.basic.utils.StringUtil;
import com.sy.spring.cloud.alibaba.provider.basic.web.R;
import io.swagger.annotations.*;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.data.domain.Page;
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


    @Reference(version = "1.0.0")
    private UserInfoEsService userInfoEsService;




    @PostMapping("/login")
    @ApiOperation(value = "用户登陆",notes = "有两种方式： 1、使用帐号（邮箱或手机后）密码，2、使用手机号和验证码")
    public R<UserLoginVo> login(@RequestBody AuthLoginDto authLoginVo){
        UserLoginVo userLoginVo ;
        if (!"".equals(authLoginVo.getMobile())&&authLoginVo.getMobile()!=null){
            if("".equals(authLoginVo.getCode())){
                return R.fail("请求输入验证码");
            }
            userLoginVo = userDetailService.userLoginByCode(authLoginVo.getMobile(),authLoginVo.getCode());
            return R.succeed("登陆成功",userLoginVo);
        }
        userLoginVo = userInfoService.userLoginByEvidence(authLoginVo);
        return R.succeed("登陆成功",userLoginVo);
    }



    @GetMapping("/checkEmail")
    @ApiOperation(value = "校验手机号、邮箱、QQ是否被注册过",notes = "一个手机号、邮箱、QQ只能绑定一个帐号，所以需要校验是否被注册使用过,校验哪个传哪个")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "手机号",name = "mobile",paramType="query"),
            @ApiImplicitParam(value = "邮箱",name = "email",paramType="query"),
            @ApiImplicitParam(value = "QQ号",name = "qq",paramType="query"),
    })
    public R checkAcc(String mobile, String email, String qq){
        String s = userInfoService.checkAcc(mobile,email,qq);
        if (s==null){
            return R.succeed("未绑定");
        }
        return R.fail("该信息已被使用");
    }

    @PostMapping("/register")
    @ApiOperation(value = "注册个人信息",notes = "注册的认证方式选择邮箱验证码")
    public R testEmial(@RequestBody @Valid RegisterUserDto registerUserDto){
        UserLoginVo register = userDetailService.register(registerUserDto);
        return R.succeed("注册成功",register);
    }



    @PostMapping("/logout")
    @ApiOperation(value = "注销登陆")
    public R logout(){
        return null;
    }


    @GetMapping("/getMobileCode")
    @ApiOperation(value = "获取手机验证码",notes = "注册时获取手机验证码")
    @ApiImplicitParam(value = "手机号",paramType = "query",name = "mobile",required = true)
    public R getMobileCode(String mobile){
        boolean b = StringUtil.matchMobile(mobile);
        if (!b){
            return R.fail("请输入正确的手机号");
        }
        userDetailService.getMobileCode(mobile);
        return R.succeed("验证码已发送");
    }

    @GetMapping("/getEmailCode")
    @ApiOperation(value = "获取邮箱验证码",notes = "注册时获取邮箱验证码")
    @ApiImplicitParam(value = "邮箱",paramType = "query",name = "email",required = true)
    public R getEmailCode(String email){
        boolean b = StringUtil.matchEmail(email);
        if (!b){
            return R.fail("请输入正确的邮箱");
        }
        userDetailService.getEmailCode(email);
        return R.succeed("邮箱已发送");
    }



    @PostMapping("updPwd")
    @ApiOperation(value = "修改密码")
    public R updPassword(@RequestBody UpdPasswordDto passwordDto){
        userInfoService.updPasswordByDto(passwordDto);
        return R.succeed("修改成功");
    }

    @GetMapping("/getByKeyword")
    @ApiOperation(value = "根据关键字查询用户信息")
    public R<Page<UserInfo>> get(@RequestParam(value = "keyword") String keyword){
        Page<UserInfo> byKeyword = userInfoEsService.findByKeyword(keyword,0,10);
        return R.succeed(byKeyword);
    }


}
