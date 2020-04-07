package com.sy.spring.cloud.alibaba.auth.user.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author ：sy
 * @date ：Created in 2020.3.29 21:07
 * @description: 登陆
 */
@ApiModel("登陆")
public class AuthLoginDto implements Serializable {


    private static final long serialVersionUID = 436620244711565502L;


    @ApiModelProperty(value = "登陆凭证：QQ、手机号或者邮箱, 与手机号两者必传其中一个")
    private String evidence;


    @ApiModelProperty(value = "登陆密码")
    private String password;


    @ApiModelProperty(value = "手机验证码")
    private String code;

    @ApiModelProperty(value = "手机号")
    private String mobile;



    public String getEvidence() {
        return evidence;
    }

    public void setEvidence(String evidence) {
        this.evidence = evidence;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
