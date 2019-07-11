package com.kj.consul.provider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consul")
public class ProviderController {

    @GetMapping("/test")
    public String testConsul(){
        return "testConsul ok!";
    }
}
