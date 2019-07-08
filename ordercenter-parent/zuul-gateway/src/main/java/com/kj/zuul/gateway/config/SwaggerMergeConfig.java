package com.kj.zuul.gateway.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

/**
 * 
 * @author xiefk
 * @version $Id: SwaggerMergeConfig.java, v 0.1 2019年7月4日 下午5:38:56 xiefk Exp $
 * 通过网关统一管理swagger接口文档 需要把相关接口放进下面的resource,直接调用http://localhost:8888/swagger-ui.html
 */
@Configuration
@Primary
public class SwaggerMergeConfig implements SwaggerResourcesProvider {

    public List<SwaggerResource> get() {
        List<SwaggerResource> resources = new ArrayList<SwaggerResource>();
        resources.add(swaggerResource("provider", "/provider-service/v2/api-docs", "2.0"));
        resources.add(swaggerResource("order", "/order-service/v2/api-docs", "2.0"));
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
