package com.sy.spring.cloud.alibaba.auth.user.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author ：sy
 * @date ：Created in 2020.3.29 21:07
 * @description: 登陆
 */
@Data
@ApiModel("登陆")
public class AuthLoginVo  implements Serializable {


    private static final long serialVersionUID = 436620244711565502L;


    @ApiModelProperty(value = "登陆凭证，QQ或者邮箱")
    private String evidence;



    @ApiModelProperty(value = "登陆密码")
    private String password;


    @ApiModelProperty(value = "手机验证码")
    private String code;

    @ApiModelProperty(value = "手机号")
    private String mobile;








}
