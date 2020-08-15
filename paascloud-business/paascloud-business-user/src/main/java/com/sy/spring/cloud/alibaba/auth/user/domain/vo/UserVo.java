package com.sy.spring.cloud.alibaba.auth.user.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author ：sy
 * @date ：Created in 2020.4.4 17:57
 * @description: 返回的用户对象
 */
@ApiModel
@Data
public class UserVo implements Serializable {


    /**
     * 主键id
     */
    @ApiModelProperty(value="主键id")
    private Integer id;

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

}
