package com.kj.order.feign;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kj.order.feign.fallback.ProviderInvokerFallback;

/**
 * 
 * @author xiefk
 * @version $Id: ProviderInvokerService.java, v 0.1 2019年7月3日 下午7:07:11 xiefk Exp $
 * 使用feign远程调用
 */
@FeignClient(value = "provider-service",fallback = ProviderInvokerFallback.class, contextId = "providerService")
public interface ProviderInvokerService {

    @RequestMapping(value  = "/provider/test",method = RequestMethod.GET)
    String test(@RequestParam(value = "name") String name);
}
