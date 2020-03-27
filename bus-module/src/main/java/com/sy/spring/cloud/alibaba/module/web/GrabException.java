package com.sy.spring.cloud.alibaba.module.web;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author ：sy
 * @date ：Created in 2020.3.26 21:53
 * @description: 自定义异常
 */
@Slf4j
@Data
public class GrabException extends RuntimeException {

    private Integer code;

    private String msg;

    public GrabException(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }


}
