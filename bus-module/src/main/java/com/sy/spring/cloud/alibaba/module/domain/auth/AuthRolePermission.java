package com.sy.spring.cloud.alibaba.module.domain.auth;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

/**
    * 角色权限表
    */
@ApiModel(value="com-sy-spring-cloud-alibaba-module-domain-auth-AuthRolePermission")
@Data
public class AuthRolePermission implements Serializable {
    @ApiModelProperty(value="")
    private Long id;

    /**
    * 角色 ID
    */
    @ApiModelProperty(value="角色 ID")
    private Long roleId;

    /**
    * 权限 ID
    */
    @ApiModelProperty(value="权限 ID")
    private Long permissionId;

    private static final long serialVersionUID = 1L;
}