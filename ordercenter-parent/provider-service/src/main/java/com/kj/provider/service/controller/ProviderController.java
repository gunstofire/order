package com.kj.provider.service.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderController {

	@Value("${server.port}")
	private int port;
	@RequestMapping(value = "/get",method =  RequestMethod.GET)
	public String findProvider() {
		return "invoked get success";
	}
	
	@RequestMapping(value = "/find",method =  RequestMethod.GET)
	public String find() {
		System.err.println("invoked port:"+port);
		return "invoked find success";
	}
}
