package com.sy.spring.cloud.alibaba.provider.basic.domain.auth;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@ApiModel(value="userInfo")
@Data
public class UserInfo implements Serializable {
    /**
    * 主键id
    */
    @Field(type = FieldType.Integer)
    @ApiModelProperty(value="主键id")
    private Integer id;


    /**
     * 使用名
     *
     *
     *
     * analyzer 存入时是否使用分词
     * type 在es里的类型。不指定可自动
     * store 是否独立存储
     * searchAnalyzer 查询分词
     */
    @Field(analyzer = "ik_max_word",type = FieldType.Text,store = true,searchAnalyzer = "ik_max_word")
    @ApiModelProperty(value="使用名")
    private String userName;

    /**
    * 真实姓名
    */
    @Field(analyzer = "ik_max_word",type = FieldType.Text,store = true,searchAnalyzer = "ik_max_word")
    @ApiModelProperty(value="真实姓名")
    private String realName;

    /**
    * QQ号
    */
    @Field(type = FieldType.Text,store = true)
    @ApiModelProperty(value="QQ号")
    private String qq;

    /**
    * 微信
    */
    @Field(analyzer = "ik_max_word",type = FieldType.Text,store = true,searchAnalyzer = "ik_max_word")
    @ApiModelProperty(value="微信")
    private String wechat;

    /**
    * 邮箱
    */
    @ApiModelProperty(value="邮箱")
    @Field(type = FieldType.Text,store = true)
    private String email;

    /**
    * 手机号
    */
    @ApiModelProperty(value="手机号")
    @Field(type = FieldType.Text,store = true)
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
    @Field(type = FieldType.Double,store = true)
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
    @Field(analyzer = "ik_max_word",type = FieldType.Text,store = true,searchAnalyzer = "ik_max_word")
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
