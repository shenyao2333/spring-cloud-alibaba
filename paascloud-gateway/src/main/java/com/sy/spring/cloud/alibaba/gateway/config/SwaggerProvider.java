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


        List<String> routeHosts = new ArrayList<>();
        // 过滤不必要的模块。host转小写
        routeLocator.getRoutes().filter(route -> route.getUri().getHost() != null)
                .filter(route -> !"API-GATEWAY".equals(route.getUri().getHost()))
                .filter(route -> !"ADMIN-SERVER".equals(route.getUri().getHost()))
                .subscribe(route -> routeHosts.add(route.getUri().getHost().toLowerCase()));
        Set<String> dealed = new HashSet<>();
        routeHosts.forEach(instance -> {
            // 拼接url
            String url = "/" + instance + SWAGGER2URL;
            log.info("加载的Url---->"+url);
            if (!dealed.contains(url)) {
                dealed.add(url);
                SwaggerResource swaggerResource = new SwaggerResource();
                swaggerResource.setUrl(url);
                swaggerResource.setName(instance);
                resources.add(swaggerResource);
            }
        });
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
