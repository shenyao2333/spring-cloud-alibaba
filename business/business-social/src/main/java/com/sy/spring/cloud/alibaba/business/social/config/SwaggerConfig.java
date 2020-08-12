package com.sy.spring.cloud.alibaba.business.social.config;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import io.swagger.annotations.ApiOperation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author sy
 * @date: 2020/8/12 14:19
 * @description swaage配置类
 */
@EnableSwagger2
@EnableSwaggerBootstrapUI
@Configuration
public class SwaggerConfig {

    @Bean
    @Order(value = 1)
    public Docket createRestApi() {

        return new Docket(DocumentationType.SWAGGER_2)
                .enable(true)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Swagger API")
                .description("这个是一个社交模块，目前只是图片的东西")
                .termsOfServiceUrl("")
                .contact(new Contact("shenyao", "www.sy91aa.com", "sy91aa@163.com"))
                .version("1.0.0")
                .build();
    }
}
