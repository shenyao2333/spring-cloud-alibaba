package com.sy.spring.cloud.alibaba.module.domain.auth;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

/**
    * 用户角色表
    */
@ApiModel(value="com-sy-spring-cloud-alibaba-module-domain-auth-AuthUserRole")
@Data
public class AuthUserRole implements Serializable {
    @ApiModelProperty(value="")
    private Long id;

    /**
    * 用户 ID
    */
    @ApiModelProperty(value="用户 ID")
    private Long userId;

    /**
    * 角色 ID
    */
    @ApiModelProperty(value="角色 ID")
    private Long roleId;

    private static final long serialVersionUID = 1L;
}