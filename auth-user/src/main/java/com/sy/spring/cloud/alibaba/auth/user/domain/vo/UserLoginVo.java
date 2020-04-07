package com.sy.spring.cloud.alibaba.auth.user.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author ：sy
 * @date ：Created in 2020.4.4 17:55
 * @description: 用户登录后返回
 */
@ApiModel("登陆成功")
public class UserLoginVo implements Serializable {

    private static final long serialVersionUID = 1013200628976912905L;

    @ApiModelProperty("登录凭证")
    private String token;


    @ApiModelProperty("用户信息")
    private UserVo userVo;

    @ApiModelProperty("凭证有效时间")
    private Long validTime;


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UserVo getUserVo() {
        return userVo;
    }

    public void setUserVo(UserVo userVo) {
        this.userVo = userVo;
    }

    public Long getValidTime() {
        return validTime;
    }

    public void setValidTime(Long validTime) {
        this.validTime = validTime;
    }
}
