package com.sy.spring.cloud.alibaba.business.user.domain.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * @author sy
 * @date Created in 2020.5.30 21:16
 * @description 修改用户信息对象
 */
@Data
public class UpdUserInfoDto  {


    /**
     * 主键id
     */
    @ApiModelProperty(value="主键id",required = true,example = "12")
    @NotBlank(message = "修改的用户id不能为空")
    private Long id;

    /**
     * 使用名
     */
    @ApiModelProperty(value="使用名")
    private String userName;

    /**
     * 真实姓名
     */
    @ApiModelProperty(value="真实姓名")
    private String realName;

    /**
     * QQ号
     */
    @ApiModelProperty(value="QQ号")
    private String qq;

    /**
     * 微信
     */
    @ApiModelProperty(value="微信")
    private String wechat;



    /**
     * 头像地址
     */
    @ApiModelProperty(value="头像地址")
    private String photoUrl;

    /**
     * 年龄
     */
    @ApiModelProperty(value="年龄")
    private String age;

    /**
     * 0/女，1/男，2/保密
     */
    @ApiModelProperty(value="0/女，1/男，2/保密")
    private String sex;

    /**
     * 个性签名
     */
    @ApiModelProperty(value="个性签名")
    private String personalized;

    /**
     * 生日
     */
    @ApiModelProperty(value="生日")
    private Date birthday;





    /**
     * 国家
     */
    @ApiModelProperty(value="国家")
    private String country;

    /**
     * 省份
     */
    @ApiModelProperty(value="省份")
    private String province;

    /**
     * 市
     */
    @ApiModelProperty(value="市")
    private String city;

    /**
     * 县/区
     */
    @ApiModelProperty(value="县/区")
    private String county;

    /**
     * 地址
     */
    @ApiModelProperty(value="地址")
    private String address;


    private static final long serialVersionUID = 1L;


}
