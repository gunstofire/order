package com.kj.zuul.gateway.filter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

/**
 * 
 * @author xiefk
 * @version $Id: RequestFilter.java, v 0.1 2019年7月3日 下午3:34:30 xiefk Exp $
 * 请求过滤器
 */
@Component
public class RequestFilter extends ZuulFilter{

    //这里可以处理逻辑
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
 
        System.out.println(String.format(request.getMethod(), request.getRequestURL().toString()));
        // 对该请求进行路由
        ctx.setSendZuulResponse(true);
        ctx.setResponseStatusCode(200);
        // 设值，让下一个Filter看到上一个Filter的状态
        ctx.set("isSuccess", true);
        return null;
    }
    //控制过滤器生效不生效，可以在里面写一串逻辑来控制,true是生效
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        System.err.println("zuul gateway shouldFilter:"+request.getRequestURL().toString());
        return true;
    }

    /**
     * 优先级为0，数字越大，优先级越低
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    // 前置过滤器
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

}
