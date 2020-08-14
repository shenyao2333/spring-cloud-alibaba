package com.sy.spring.cloud.alibaba.provider.basic.domain.auth;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
    * 角色表
    */
@ApiModel(value="com-sy-spring-cloud-alibaba-module-domain-auth-AuthRole")
@Data
public class AuthRole implements Serializable {
    @ApiModelProperty(value="主键id")
    private Long id;

    /**
    * 父角色
    */
    @ApiModelProperty(value="父角色")
    private Long parentId;

    /**
    * 角色名称
    */
    @ApiModelProperty(value="角色名称")
    private String name;

    /**
    * 角色英文名称
    */
    @ApiModelProperty(value="角色英文名称")
    private String enname;

    /**
    * 备注
    */
    @ApiModelProperty(value="备注")
    private String description;

    /**
     * 创建时间
     */
    @ApiModelProperty(value="创建时间")
    private Date created;

    /**
     * 更新时间
     */
    @ApiModelProperty(value="更新时间")
    private Date updated;

    /**
    * 状态
    */
    @ApiModelProperty(value="状态")
    private String status;

    private static final long serialVersionUID = 1L;
}
