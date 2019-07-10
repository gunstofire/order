package com.kj.order.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableAdminServer
public class MonitorApplication 
{
    public static void main( String[] args )
    {
        SpringApplication.run(MonitorApplication.class, args);
    }
}
