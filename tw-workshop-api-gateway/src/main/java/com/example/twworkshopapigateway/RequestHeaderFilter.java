package com.example.twworkshopapigateway;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RequestHeaderFilter extends ZuulFilter {
    private final static Logger logger = LoggerFactory.getLogger(RequestHeaderFilter.class);

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext context = RequestContext.getCurrentContext();
        String tokenValue = context.getZuulRequestHeaders().get("zuul-token");

        logger.info("zuul token: {}", tokenValue);
        return null;
    }

}
