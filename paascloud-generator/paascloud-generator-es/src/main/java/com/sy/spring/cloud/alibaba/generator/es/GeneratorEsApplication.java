package com.sy.spring.cloud.alibaba.generator.es;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author sy
 * @date: 2020/8/15 10:13
 * @description
 */
@EnableAsync
@SpringBootApplication
@EnableDiscoveryClient
@EnableCaching
public class GeneratorEsApplication {

    public static void main(String[] args) {
        SpringApplication.run(GeneratorEsApplication.class, args);
    }
}
