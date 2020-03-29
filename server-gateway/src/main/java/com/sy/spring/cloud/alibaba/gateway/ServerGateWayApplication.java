package com.sy.spring.cloud.alibaba.gateway;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ServerGateWayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerGateWayApplication.class, args);
    }

}

