package com.sy.spring.cloud.alibaba.auth.user.domain.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author sy
 * @date Created in 2020.5.30 21:28
 * @description 修改密码
 */
@Data
public class UpdPasswordDto {

    @NotBlank(message = "邮箱号不能为空")
    @ApiModelProperty(value = "邮箱（登录账户）",required = true,example = "10406@qq.com")
    private String email;

    @ApiModelProperty(value = "旧密码",required = true,example = "123123123")
    private String oldPassword;


    @ApiModelProperty(value = "新的密码",required = true,example = "123456")
    private String newPassword;


}
