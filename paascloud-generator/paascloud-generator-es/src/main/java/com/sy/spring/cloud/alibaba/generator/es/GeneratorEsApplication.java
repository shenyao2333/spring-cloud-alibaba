package com.sy.spring.cloud.alibaba.generator.es;

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
 * @date: 2020/8/15 10:13
 * @description
 */
@EnableAsync
@SpringBootApplication
@EnableDiscoveryClient
@EnableCaching
@EnableSwagger2
@MapperScan(basePackages = "com.sy.spring.cloud.alibaba.auth.user.mapper")
@ComponentScan(basePackages = {"com.sy.spring.cloud.alibaba.provider.basic"})
@EnableFeignClients("com.sy.spring.cloud.alibaba.provider.api.feign")
public class GeneratorEsApplication {

    public static void main(String[] args) {
        SpringApplication.run(GeneratorEsApplication.class, args);
    }
}
