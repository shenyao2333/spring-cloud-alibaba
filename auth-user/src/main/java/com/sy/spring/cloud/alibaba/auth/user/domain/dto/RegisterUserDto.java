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
@Data
public class RegisterUserDto implements Serializable {

    private static final long serialVersionUID = 2765589263616205597L;


    @Email(message = "邮箱格式错误")
    @NotBlank(message = "邮箱不能为空")
    @ApiModelProperty(value = "邮箱",required = true,example = "1040676712@qq.com")
    private String email;

    @Pattern(regexp = "1[3|4|5|7|8|9][0-9]\\d{8}",message = "手机格式不正确")
    @NotBlank(message = "手机号不能为空")
    @ApiModelProperty(value = "手机号",required = true,example = "15578973333")
    private String mobile;


    @ApiModelProperty(value = "密码",required = true,example = "123123")
    @NotBlank(message = "登录不能为空")
    private String password;


    @NotBlank(message = "邮箱验证码不能为空")
    @ApiModelProperty(value = "邮箱验证码",required = true,example = "2324")
    private String emailCode;


}
