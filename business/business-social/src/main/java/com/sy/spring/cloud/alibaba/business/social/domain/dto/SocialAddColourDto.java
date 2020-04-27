package com.sy.spring.cloud.alibaba.business.social.domain.dto;

import com.sy.spring.cloud.alibaba.business.social.domain.HiapkColour;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author sy
 * @date: 2020/4/27 11:18
 * @description 添加色系接收对象
 */
@Data
@ApiModel
public class SocialAddColourDto extends HiapkColour implements Serializable {

    private static final long serialVersionUID = -1876293273625530701L;


    /**
     * 色系名
     */
    @NotBlank(message = "色系名不能为空")
    @ApiModelProperty(value="色系名",example = "红色",required = true)
    private String colour;

    /**
     * 描述
     */
    @ApiModelProperty(value="描述",example = "超暖色")
    private String msg;

    /**
     * 色号
     */
    @NotBlank(message = "色号不能为空")
    @ApiModelProperty(value="色号",example = "#FFF001",required = true)
    private String colourNumber;




}
