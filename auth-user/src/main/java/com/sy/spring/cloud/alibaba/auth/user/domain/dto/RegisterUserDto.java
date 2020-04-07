package com.sy.spring.cloud.alibaba.auth.user.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @author sy
 * @date Created in 2020.4.5 1:17
 * @description 注册用户dto
 */
@ApiModel
public class RegisterUserDto implements Serializable {

    private static final long serialVersionUID = 2765589263616205597L;


    @Email
    @NotBlank(message = "邮箱不能为空")
    @ApiModelProperty(value = "邮箱",required = true,example = "1040676712@qq.com")
    private String email;

    @Pattern(regexp = "1[3|4|5|7|8|9][0-9]\\d{8}")
    @NotBlank(message = "手机号不能为空")
    @ApiModelProperty(value = "手机号",required = true,example = "15578973333")
    private String mobile;


    @ApiModelProperty(value = "密码",required = true,example = "123123")
    @NotBlank(message = "登录不能为空")
    private String password;


    @NotBlank(message = "邮箱验证码不能为空")
    @ApiModelProperty(value = "邮箱验证码",required = true,example = "2324")
    private String emailCode;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailCode() {
        return emailCode;
    }

    public void setEmailCode(String emailCode) {
        this.emailCode = emailCode;
    }
}
