package com.sy.spring.cloud.alibaba.business.social.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

@ApiModel(value="HiapkColour")
@Data
public class HiapkColour implements Serializable {
    /**
    * 主键id
    */
    @ApiModelProperty(value="主键id")
    private Long id;

    /**
    * 色系名
    */
    @ApiModelProperty(value="色系名")
    private String colour;

    /**
    * 描述
    */
    @ApiModelProperty(value="描述")
    private String msg;

    /**
     * 色号
     */
    @ApiModelProperty(value="色号",example = "#FFF001")
    private String colourNumber;

    private static final long serialVersionUID = 1L;
}
