package com.sy.spring.cloud.alibaba.auth.user;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableDiscoveryClient
@EnableAsync
@EnableSwagger2
@MapperScan(basePackages = "com.sy.spring.cloud.alibaba.auth.user.mapper")
@ComponentScan(basePackages = {"com.sy.spring.cloud.alibaba.auth.user", "com.sy.spring.cloud.alibaba.module" })
public class AuthUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthUserApplication.class, args);
    }



}

