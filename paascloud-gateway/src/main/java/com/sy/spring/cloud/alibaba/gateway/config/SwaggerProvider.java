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
public class SwaggerProvider implements SwaggerResourcesProvider {



    /**
     * swagger2默认的url后缀SwaggerProvider
     */
    private static final String API_URI = "/v2/api-docs";


    @Override
    public List<SwaggerResource> get() {
        List<SwaggerResource> resources = new ArrayList<>();
        resources.add(swaggerResource("社交模块","/business-social"));
        resources.add(swaggerResource("商品模块","/"));
        resources.add(swaggerResource("用户模块","/"));
        resources.add(swaggerResource("第三方模块","/"));
        resources.add(swaggerResource("任务模块","/"));
        return resources;
    }

    private SwaggerResource swaggerResource(String name, String location) {
        log.info("name:{},location:{}",name,location);
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setLocation(location+API_URI);
        swaggerResource.setSwaggerVersion("1.0.0");
        return swaggerResource;
    }


}
