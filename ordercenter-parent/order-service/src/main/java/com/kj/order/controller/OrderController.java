package com.kj.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kj.order.feign.ProviderInvokerService;
import com.kj.order.service.OrderService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value ="order-service")
@RestController
@RequestMapping("order")
public class OrderController {

	@Autowired
	OrderService orderService;
	
	@Autowired
	ProviderInvokerService providerInvokerService;
	
	@Autowired
    RedisTemplate<String, String> redisTemplate;
	
	@ApiOperation(value="订单测试服务", notes="列表数据查询")
    @ApiImplicitParams({ 
            @ApiImplicitParam(name = "test", value = "测试写法，该接口不需要参数", required = false, paramType = "query")
    })
	@RequestMapping(value = "list",method = RequestMethod.GET)
	public String list() {
	    //rediscunc
		redisTemplate.opsForValue().set("test", "4321");
		//feign远程调用，provider服务
		String romoteValue = providerInvokerService.test("testname");
		
		return orderService.list().size()+":success/"+romoteValue;
	}
}
