package com.sy.spring.cloud.alibaba.gateway;


import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableAsync;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * @author my
 */
@EnableCaching
@SpringBootApplication
@EnableDiscoveryClient
@EnableAsync
public class ServerGateWayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerGateWayApplication.class, args);
    }

}

