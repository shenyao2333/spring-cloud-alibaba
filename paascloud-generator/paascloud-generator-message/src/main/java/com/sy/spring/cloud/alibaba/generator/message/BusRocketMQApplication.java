package com.sy.spring.cloud.alibaba.generator.message;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author sy
 * @date Created in 2020.4.26 15:03
 * @description 启动类
 */
@EnableSwagger2
@SpringBootApplication
@EnableDiscoveryClient
@EnableAsync
@MapperScan(basePackages = "com.sy.spring.cloud.alibaba.generator.message")
@ComponentScan(basePackages = {"com.sy.spring.cloud.alibaba.generator.message", "com.sy.spring.cloud.alibaba.provider.basic"})
@EnableCaching
@EnableBinding({Source.class})
public class BusRocketMQApplication {

    public static void main(String[] args) {
        SpringApplication.run(BusRocketMQApplication.class, args);
    }
}
