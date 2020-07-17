package com.sy.spring.cloud.alibaba.module.config;

import feign.Contract;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author sy
 * @date Created in 2020.7.12 23:06
 * @description
 */
@Configuration
public class FeignConfig {

    @Bean
    public Contract feignConfiguration(){
        return new feign.Contract.Default();
    }
}
