package com.sy.spring.cloud.alibaba.gateway;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;


/**
 * @author my
 */
@EnableCaching
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {"com.sy.spring.cloud.alibaba.gateway", "com.sy.spring.cloud.alibaba.module" })
@EnableAsync
@EnableFeignClients
public class ServerGateWayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerGateWayApplication.class, args);
    }

}

