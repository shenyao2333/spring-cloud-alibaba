package com.sy.spring.cloud.alibaba.gateway.config;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.config.GatewayProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.support.NameUtils;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author sy
 * @date Created in 2020.8.10 20:40
 * @description swagger聚合配置
 */
@Slf4j
@Component
@Primary
@AllArgsConstructor
/*@EnableSwagger2
@EnableSwaggerBootstrapUI*/
public class SwaggerProvider implements SwaggerResourcesProvider {


    private final RouteLocator routeLocator;
    private final GatewayProperties gatewayProperties;


    /**
     * swagger2默认的url后缀SwaggerProvider
     */
    private static final String SWAGGER2URL = "/v2/api-docs";


    @Override
    public List<SwaggerResource> get() {
        List<SwaggerResource> resources = new ArrayList<>();
        resources.add(swaggerResource("社交","/business-social/v2/api-docs"));
        return resources;
    }

    private SwaggerResource swaggerResource(String name, String location) {

        log.info("name:{},location:{}",name,location);
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setLocation(location);
        swaggerResource.setSwaggerVersion("1.0.0");
        return swaggerResource;
    }

    private SwaggerResource swaggerResource(String name, String location, String version) {
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setLocation(location);
        swaggerResource.setSwaggerVersion(version);
        return swaggerResource;
    }
}
