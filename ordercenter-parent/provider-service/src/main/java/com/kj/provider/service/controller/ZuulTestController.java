package com.kj.provider.service.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value ="ZuulTest")
@RestController
@RequestMapping("provider")
public class ZuulTestController {

    
    @ApiOperation(value="zuul网关测试服务", notes="zuul网关测试服务")
    @ApiImplicitParams({ 
            @ApiImplicitParam(name = "test", value = "测试写法", required = false, paramType = "query")
    })
	@RequestMapping(value = "test",method = RequestMethod.GET)
	public String test(@RequestParam(value = "name") String name) {
		System.err.println("invoked test:"+name);
		return "invoked test success";
	}
}
