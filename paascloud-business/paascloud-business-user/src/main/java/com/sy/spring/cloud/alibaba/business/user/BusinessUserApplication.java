package com.sy.spring.cloud.alibaba.business.user;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
@EnableDiscoveryClient
@EnableAsync
@MapperScan(basePackages = "com.sy.spring.cloud.alibaba.business.user.mapper")
@ComponentScan(basePackages = {"com.sy.spring.cloud.alibaba.business.user", "com.sy.spring.cloud.alibaba.provider.basic"})
@EnableCaching
@EnableFeignClients("com.sy.spring.cloud.alibaba.provider.api.feign")
public class BusinessUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(BusinessUserApplication.class, args);
    }

}

