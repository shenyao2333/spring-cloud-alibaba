package com.sy.spring.cloud.alibaba.module.web;

import lombok.Data;

/**
 * @author ：sy
 * @date ：Created in 2020.3.26 21:53
 * @description: 自定义枚举
 */
public enum ErrorEnum {


    /**
     * 成功
     */
    SUCCEED(RespBean.CodeStatus.OK,"处理成功"),

    /**
     * 自定义错误处理
     */
    SYS(RespBean.CodeStatus.SYS,"系统错误"),

    REQUEST(RespBean.CodeStatus.REQUEST,"请求错误"),


    POWER (RespBean.CodeStatus.POWER,"无权访问"),


    DATA (RespBean.CodeStatus.DATA,"数据异常"),

    ANOMALY(RespBean.CodeStatus.ANOMALY,"未知异常"),

    NET (RespBean.CodeStatus.NET,"网络异常"),



    EXPIRED(RespBean.CodeStatus.EXPIRED,"令牌错误"),
    LONG_ERR(7001,"帐号或密码错误"),
    CODE_ERR(7002,"验证码错误"),
    UNREGISTERED_MOBILE(7003,"该手机号未注册"),
    UNREGISTERED_EMAIL(7003,"该邮箱未注册"),


    EXTERN(RespBean.CodeStatus.EXTERN,"第三方错误"),




    ;


    private Integer code;

    private String msg;

    ErrorEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
