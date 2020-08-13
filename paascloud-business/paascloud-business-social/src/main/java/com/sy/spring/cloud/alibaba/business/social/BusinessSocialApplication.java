package com.sy.spring.cloud.alibaba.business.social;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author sy
 * @date Created in 2020.4.26 15:03
 * @description 启动类
 */

@SpringBootApplication
@EnableDiscoveryClient
@EnableAsync
@MapperScan(basePackages = "com.sy.spring.cloud.alibaba.business.social.mapper")
@ComponentScan(basePackages = {"com.sy.spring.cloud.alibaba.business.social", "com.sy.spring.cloud.alibaba.module","com.sy.spring.cloud.alibaba.bus.api.feign" })
@EnableCaching
@EnableFeignClients("com.sy.spring.cloud.alibaba.bus.api.feign.businessgoods")
public class BusinessSocialApplication {

    public static void main(String[] args) {
        SpringApplication.run(BusinessSocialApplication.class, args);
    }
}