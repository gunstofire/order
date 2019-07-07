package com.kj.provider.service.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("provider")
public class ZuulTestController {

	@RequestMapping(value = "test",method = RequestMethod.GET)
	public String test() {
		System.err.println("invoked test");
		return "invoked test success";
	}
}
