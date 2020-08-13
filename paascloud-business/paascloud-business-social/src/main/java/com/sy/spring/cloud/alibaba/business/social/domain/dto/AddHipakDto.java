package com.sy.spring.cloud.alibaba.business.social.domain.dto;

import com.sy.spring.cloud.alibaba.business.social.domain.SocialImg;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author sy
 * @date Created in 2020.4.29 21:29
 * @description 添加图片对象
 */
@Data
@ApiModel
public class AddHipakDto extends SocialImg  implements Serializable {


    private static final long serialVersionUID = 7838926830005213394L;


    /**
     * 图片地址
     */
    @ApiModelProperty(value="图片地址",required = true,example = "http://asdfsaf/2.png")
    @NotBlank(message = "请求输入图片路径")
    private String url;

    /**
     * 类型ID
     */
    @NotBlank(message = "请选择图片类型")
    @ApiModelProperty(value="类型ID",required = true,example = "1")
    private Long typeId;

    /**
     * 色系ID
     */
    @ApiModelProperty(value="色系ID",example = "1")
    private Long colourId;

    /**
     * 尺寸ID
     */
    @ApiModelProperty(value="尺寸ID")
    private Long sizeId;


    @ApiModelProperty(value="描述")
    private String msg;

    @ApiModelProperty(value="备注")
    private String describe;

    /**
     * 下载类型: 0/免费   1/积分下载
     */
    @NotBlank(message = "请求设置图片下载类型")
    @ApiModelProperty(value="下载类型: 0/免费   1/积分下载",required = true,example = "0")
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
    @ApiModelProperty(value="图片所有人的id")
    private String userId;


}
