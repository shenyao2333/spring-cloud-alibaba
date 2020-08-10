package com.sy.spring.cloud.alibaba.gateway.config;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;

/**
 * @author sy
 * @date Created in 2020.8.10 20:39
 * @description swagger 相关配置
 */
public class SwaggerHeaderFilter extends AbstractGatewayFilterFactory {


    @Override
    public GatewayFilter apply(Object config) {
        return null;
    }
}
