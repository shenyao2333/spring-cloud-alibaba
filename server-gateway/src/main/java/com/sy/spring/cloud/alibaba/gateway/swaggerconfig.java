package com.sy.spring.cloud.alibaba.gateway;

import org.assertj.core.util.Lists;

import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.List;

/**
 * @author sy
 * @date Created in 2020.4.6 16:10
 * @description
 */
public class swaggerconfig implements SwaggerResourcesProvider {


    @Override
    public List<SwaggerResource> get() {
        List<SwaggerResource> resources = Lists.newArrayList();
        resources.add(swaggerResource("数据服务", "/api-bdata/v2/api-docs", "1.0"));
        resources.add(swaggerResource("业务服务", "/api-tripartite/v2/api-docs", "1.0"));
        resources.add(swaggerResource("微信服务", "/api-wechat/v2/api-docs", "1.0"));
        resources.add(swaggerResource("钉钉服务", "/api-dingtalk/v2/api-docs", "1.0"));
        resources.add(swaggerResource("消息服务", "/api-msg/v2/api-docs", "1.0"));
        resources.add(swaggerResource("权限服务", "/api-auth/v2/api-docs", "1.0"));
        resources.add(swaggerResource("任务服务", "/api-task/v2/api-docs", "1.0"));
        return resources;
    }

    private SwaggerResource swaggerResource(String name, String location, String version) {
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setLocation(location);
        swaggerResource.setSwaggerVersion(version);
        return swaggerResource;
    }




}
