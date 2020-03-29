package com.sy.spring.cloud.alibaba.module.domain.auth;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@ApiModel(value="com-sy-spring-cloud-alibaba-module-domain-auth-UserInfo")
@Data
public class UserInfo implements Serializable {
    /**
    * 主键id
    */
    @ApiModelProperty(value="主键id")
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
    * 邮箱
    */
    @ApiModelProperty(value="邮箱")
    private String email;

    /**
    * 手机号
    */
    @ApiModelProperty(value="手机号")
    private String mobile;

    /**
    * 密码
    */
    @ApiModelProperty(value="密码")
    private String password;

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
    * 创建时间
    */
    @ApiModelProperty(value="创建时间")
    private Date createTime;

    /**
    * 更新时间
    */
    @ApiModelProperty(value="更新时间")
    private Date updateTime;

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

    /**
    * 状态
    */
    @ApiModelProperty(value="状态")
    private String status;

    private static final long serialVersionUID = 1L;
}