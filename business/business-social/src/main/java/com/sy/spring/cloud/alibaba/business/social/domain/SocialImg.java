package com.sy.spring.cloud.alibaba.business.social.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

@ApiModel(value="com-sy-spring-cloud-alibaba-business-social-domain-SocialImg")
@Data
public class SocialImg implements Serializable {
    /**
    * 主键id
    */
    @ApiModelProperty(value="主键id")
    private Long id;

    /**
    * 图片地址
    */
    @ApiModelProperty(value="图片地址")
    private String url;

    /**
    * 类型ID
    */
    @ApiModelProperty(value="类型ID")
    private Long typeId;

    /**
    * 色系ID
    */
    @ApiModelProperty(value="色系ID")
    private Long colourId;

    /**
    * 尺寸ID
    */
    @ApiModelProperty(value="尺寸ID")
    private Long sizeId;

    @ApiModelProperty(value="")
    private String msg;

    @ApiModelProperty(value="")
    private String describe;

    /**
    * 下载类型: 0/免费   1/积分下载
    */
    @ApiModelProperty(value="下载类型: 0/免费   1/积分下载")
    private String charge;

    /**
    * 扣除积分
    */
    @ApiModelProperty(value="扣除积分")
    private Integer reduceIntegral;

    /**
    * 1/正常 ，2/精选，3/推荐，5/删除
    */
    @ApiModelProperty(value="1/正常 ，2/精选，3/推荐，5/删除")
    private String status;

    /**
    * 图片所有人
    */
    @ApiModelProperty(value="图片所有人")
    private String userId;

    private static final long serialVersionUID = 1L;
}