package com.sy.spring.cloud.alibaba.business.social.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

@ApiModel(value="com-sy-spring-cloud-alibaba-business-social-domain-BankingType")
@Data
public class BankingType implements Serializable {
    /**
    * 主键id
    */
    @ApiModelProperty(value="主键id")
    private Integer id;

    /**
    * 系统类型
    */
    @ApiModelProperty(value="系统类型")
    private Integer systemn;

    /**
    * 类型
    */
    @ApiModelProperty(value="类型")
    private String type;

    /**
    * 值
    */
    @ApiModelProperty(value="值")
    private String val;

    private static final long serialVersionUID = 1L;
}