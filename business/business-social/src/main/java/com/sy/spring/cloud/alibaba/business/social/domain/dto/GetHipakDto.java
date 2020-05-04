package com.sy.spring.cloud.alibaba.business.social.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author sy
 * @date Created in 2020.4.29 21:18
 * @description 查询壁纸列表
 */
@Data
@ApiModel
public class GetHipakDto implements Serializable {


    private static final long serialVersionUID = -6279105905278066736L;



    @ApiModelProperty(value = "发表人id")
    private String userId;

    @ApiModelProperty(value = "发表人的用户名")
    private String userName;


    /**
     * 下载类型: 0/免费   1/积分下载
     */
    @ApiModelProperty(value="下载类型: 0/免费   1/积分下载")
    private String charge;



    @ApiModelProperty(value="扣除积分范围-开始")
    private Integer reduceIntegralStart;


    @ApiModelProperty(value="扣除积分范围-结束")
    private Integer reduceIntegralEnd;


    /**
     * 1/正常 ，2/精选，3/推荐，5/删除
     */
    @ApiModelProperty(value="1/正常 ，2/精选，3/推荐，5/删除")
    private String status;


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



    @ApiModelProperty(value="创建时间-开始")
    private  String createdStart;



    @ApiModelProperty(value="创建时间范围-结束")
    private  String createdEnd;


/*    private Integer collectStart;


    private Integer collectStart;*/


}
