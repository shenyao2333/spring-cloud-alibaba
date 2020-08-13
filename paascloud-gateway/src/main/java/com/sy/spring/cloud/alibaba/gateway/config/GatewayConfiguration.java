package com.sy.spring.cloud.alibaba.gateway.config;

import com.alibaba.csp.sentinel.adapter.gateway.common.rule.GatewayFlowRule;
import com.alibaba.csp.sentinel.adapter.gateway.common.rule.GatewayRuleManager;
import com.alibaba.csp.sentinel.adapter.gateway.sc.SentinelGatewayFilter;
import com.alibaba.csp.sentinel.adapter.gateway.sc.callback.BlockRequestHandler;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.reactive.result.view.ViewResolver;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.springframework.web.reactive.function.BodyInserters.fromValue;

/**
 * @author sy
 * @date Created in 2020.8.9 11:24
 * @description sentinel配置类
 */
@Configuration
public class GatewayConfiguration {


    @PostConstruct
    public void doInit() {
        initGatewayRules();
    }

    private void initGatewayRules() {
        Set<GatewayFlowRule> rules = new HashSet<>();
        rules.add(new GatewayFlowRule("business")
                .setCount(1)
                .setIntervalSec(1)
                .setMaxQueueingTimeoutMs(1600)
        );
        GatewayRuleManager.loadRules(rules);
    }

    /**
     * Sentinel 过滤器
     *
     * @return
     */
    @Bean
    @Order(-1)
    public GlobalFilter sentinelGatewayFilter() {
        return new SentinelGatewayFilter();
    }



    @Bean
    public BlockRequestHandler blockRequestHandler() {
        return new BlockRequestHandler() {
            @Override
            public Mono<ServerResponse> handleRequest(ServerWebExchange exchange,
                                                      Throwable t) {
                return ServerResponse.status(200).contentType(MediaType.APPLICATION_JSON)
                        .body(fromValue("{\"code\": 2800, \"data\": null, \"msg\": \"请求繁忙，请稍后重试\"}"));
            }
        };
    }

}
