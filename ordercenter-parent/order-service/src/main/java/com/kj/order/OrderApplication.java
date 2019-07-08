package com.kj.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableEurekaClient
@EnableSwagger2
//启用feign进行远程调用
@EnableFeignClients
@EnableCircuitBreaker
public class OrderApplication 
{
    public static void main( String[] args )
    {
        SpringApplication.run(OrderApplication.class, args);
    }
}
