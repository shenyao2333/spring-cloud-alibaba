package com.sy.spring.cloud.alibaba.business.social;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author sy
 * @date Created in 2020.4.26 15:03
 * @description 启动类
 */

@SpringBootApplication
@EnableDiscoveryClient
@EnableAsync
@MapperScan(basePackages = "com.sy.spring.cloud.alibaba.business.social.mapper")
@ComponentScan(basePackages = {"com.sy.spring.cloud.alibaba.business.social", "com.sy.spring.cloud.alibaba.provider.basic"})
@EnableCaching
@EnableFeignClients("com.sy.spring.cloud.alibaba.provider.api.feign")
public class BusinessSocialApplication {

    public static void main(String[] args) {
        SpringApplication.run(BusinessSocialApplication.class, args);
    }
}
