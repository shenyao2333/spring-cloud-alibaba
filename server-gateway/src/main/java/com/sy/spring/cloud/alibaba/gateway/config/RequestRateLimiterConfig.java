package com.sy.spring.cloud.alibaba.gateway.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import reactor.core.publisher.Mono;

/**
 * @author sy
 * @date Created in 2020.8.2 18:14
 * @description 限流的配置类
 */
@Configuration
@Slf4j
public class RequestRateLimiterConfig {


    @Bean
    @Primary
    public   KeyResolver apiKeyResolver() {
        //按URL限流,即以每秒内请求数按URL分组统计，超出限流的url请求都将返回429状态
        log.info("加载ip限流--");
        return   exchange -> Mono.just(exchange.getRequest().getPath().toString());
    }


    @Bean
    KeyResolver userKeyResolver() {
        //按用户限流
        return exchange -> Mono.just(exchange.getRequest().getQueryParams().getFirst("user"));
    }

    @Bean
    KeyResolver ipKeyResolver() {
        //按IP来限流
        return exchange -> Mono.just(exchange.getRequest().getRemoteAddress().getHostName());
    }
















}
