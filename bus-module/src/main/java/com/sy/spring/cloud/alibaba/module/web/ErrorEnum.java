package com.sy.spring.cloud.alibaba.module.web;

/**
 * @author ：sy
 * @date ：Created in 2020.3.26 21:53
 * @description: 自定义枚举
 */
public enum ErrorEnum {

    /**
     * 自定义错误处理
     */
    SYS(-1,"系统错误"),

    REQUEST(2000,"请求错误"),

    POWER (3000,"权限不足"),

    DATA (4000,"数据异常"),

    ANOMALY(-1,"系统错误"),

    NET (6000,"网络异常"),

    EXPIRED(7000,"令牌过期"),

    EXTERN(8000,"第三方错误")
    ;


    private Integer code;

    private String msg;

    ErrorEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
