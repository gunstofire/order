package com.kj.ordercenter.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Hello world!
 *
 */
@SpringCloudApplication
@EnableSwagger2
public class SpringCloudGatewayApplication 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        SpringApplication.run(SpringCloudGatewayApplication.class, args);
    }
    
    /**
     * gateway中使用RouteLocator的Bean进行路由转发，将请求进行处理，最后转发到目标的下游服务。
     * 本例中将请求转发到http://httpbin.org:80这个地址上
     * @param builder
     * @return
     */
    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                //适用于lambda表达式的接口称之为函数型接口(只有一个抽象方法)
                //含参Lambda表达式：(x) -> x.f()
                //添加一个route让请求“/get”请求都转发到“http://httpbin.org/get”
                .route(p -> p.path("/get")
                             .filters(f -> f.addRequestHeader("flag", "HelloWorld"))
                             .uri("http://httpbin.org:80"))
                .build();
    }
}
