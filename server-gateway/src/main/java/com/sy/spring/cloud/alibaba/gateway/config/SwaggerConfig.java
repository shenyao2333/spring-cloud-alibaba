
package com.sy.spring.cloud.alibaba.gateway.config;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.SwaggerResource;

import springfox.documentation.swagger.web.SwaggerResourcesProvider;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebFlux;


import java.util.List;


/**
 * @author sy
 * @date Created in 2020.4.6 16:10
 * @description
 */
@Configuration
@EnableSwagger2WebFlux
public class SwaggerConfig  {


    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Java服务端API列表")
                .description("邮箱：sy91aa@163.com")
                .termsOfServiceUrl("")
                .contact(new Contact("sy", "", "sy91aa@163.com"))
                .version("1.0")
                .build();
    }

/*
    @Bean
    UiConfiguration uiConfig() {
        return new UiConfiguration(null, "list", "alpha", "schema", UiConfiguration.Constants.DEFAULT_SUBMIT_METHODS,
                false, true, 60000L);
    }
*/


    /*@Override
    public List<SwaggerResource> get() {
        List<SwaggerResource> resources = Lists.newArrayList();
        resources.add(swaggerResource("用户模块", "/auth-user/v2/api-docs", "1.0"));
        resources.add(swaggerResource("业务服务", "/api-tripartite/v2/api-docs", "1.0"));
        resources.add(swaggerResource("微信服务", "/api-wechat/v2/api-docs", "1.0"));
        return resources;
    }*/

    private SwaggerResource swaggerResource(String name, String location, String version) {
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setLocation(location);
        swaggerResource.setSwaggerVersion(version);
        return swaggerResource;
    }




}

