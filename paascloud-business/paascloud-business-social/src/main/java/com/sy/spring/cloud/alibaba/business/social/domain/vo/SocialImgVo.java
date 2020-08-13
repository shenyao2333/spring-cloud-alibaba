package com.sy.spring.cloud.alibaba.business.social.domain.vo;

import com.sy.spring.cloud.alibaba.business.social.domain.SocialImg;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author sy
 * @date Created in 2020.4.29 21:38
 * @description
 */
//@EqualsAndHashCode(callSuper = true)
@ApiModel
@Data
public class SocialImgVo extends SocialImg  implements Serializable {


    private static final long serialVersionUID = 5950822186321895449L;



    @ApiModelProperty(value = "发表人用户名")
    private String userName;

    @ApiModelProperty(value = "头像")
    private String photoUrl;


    @ApiModelProperty(value = "类型名")
    private String typeName;



    @ApiModelProperty(value = "父级类型")
    private String typeParentId;

    @ApiModelProperty(value = "父级类型名")
    private String typeParentName;

    @ApiModelProperty(value = "图片大小")
    private String size;

    @ApiModelProperty(value = "色系")
    private String colour;

    @ApiModelProperty(value = "色号")
    private String colourNumber;




}
