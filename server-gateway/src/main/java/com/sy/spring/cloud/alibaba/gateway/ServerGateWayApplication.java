package com.sy.spring.cloud.alibaba.gateway;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * @author my
 */

@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2
@ComponentScan(basePackages = {"com.sy.spring.cloud.alibaba.gateway", "com.sy.spring.cloud.alibaba.module" })
public class ServerGateWayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerGateWayApplication.class, args);
    }

}

