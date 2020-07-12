package com.sy.spring.cloud.alibaba.module.config;

import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Configuration;

/**
 * @author sy
 * @date Created in 2020.7.12 22:20
 * @description
 */
@Configuration
public class TestFeignErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String s, Response response) {
        System.out.println("错误了");
        return null;
    }
}
