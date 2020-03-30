/*
package com.sy.spring.cloud.alibaba.auth.user.controller;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

*/
/**
 * @author ：sy
 * @date ：Created in 2020.3.29 10:47
 * @description: Swagger配置类
 *//*

@Configuration
@EnableSwaggerBootstrapUI
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.sy.spring.cloud.alibaba.auth.user"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("API须知")
                .description("项目")
                .termsOfServiceUrl("")
                .contact(new Contact("sy", "", "sy91aa@163.com"))
                .version("1.0")
                .build();
    }
}
*/
