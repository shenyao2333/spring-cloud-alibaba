package com.sy.spring.cloud.alibaba.module.domain.auth;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
    * 权限表
    */
@ApiModel(value="com-sy-spring-cloud-alibaba-module-domain-auth-AuthPermission")
@Data
public class AuthPermission implements Serializable {


    @ApiModelProperty(value="")
    private Long id;

    /**
    * 父权限
    */
    @ApiModelProperty(value="父权限")
    private Long parentId;

    /**
    * 权限名称
    */
    @ApiModelProperty(value="权限名称")
    private String name;

    /**
    * 权限英文名称
    */
    @ApiModelProperty(value="权限英文名称")
    private String enname;

    /**
    * 授权路径
    */
    @ApiModelProperty(value="授权路径")
    private String url;

    /**
    * 备注
    */
    @ApiModelProperty(value="备注")
    private String description;

    @ApiModelProperty(value="创建时间")
    private Date created;

    @ApiModelProperty(value="更新时间")
    private Date updated;

    private static final long serialVersionUID = 1L;
}
