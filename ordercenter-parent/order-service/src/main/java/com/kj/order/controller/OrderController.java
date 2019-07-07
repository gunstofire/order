package com.kj.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kj.order.service.OrderService;

@RestController
@RequestMapping("order")
public class OrderController {

//	@Autowired
//	OrderService orderService;
	
	@Autowired
    RedisTemplate<String, String> redisTemplate;
	
	@RequestMapping(value = "list",method = RequestMethod.GET)
	public String list() {
		redisTemplate.opsForValue().set("test", "4321");
//		return orderService.list().size()+"";
		return "success";
	}
}
