package com.sy.spring.cloud.alibaba.business.social.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

@ApiModel(value="com-sy-spring-cloud-alibaba-business-social-domain-HiapkSize")
@Data
public class HiapkSize implements Serializable {


    @ApiModelProperty(value="")
    private Long id;

    @ApiModelProperty(value="尺寸",example = "1920X1080")
    private String size;

    /**
    * 备注
    */
    @ApiModelProperty(value="备注",example = "15-23英寸")
    private String msg;

    private static final long serialVersionUID = 1L;
}
