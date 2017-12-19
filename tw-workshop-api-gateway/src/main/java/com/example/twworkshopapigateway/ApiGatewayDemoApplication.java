package com.example.twworkshopapigateway;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableZuulProxy
@RestController
public class ApiGatewayDemoApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ApiGatewayDemoApplication.class).web(true).run(args);
    }

    @RequestMapping("/timeout")
    public String timeout() throws InterruptedException {
        Thread.sleep(1000);
        return "timeout";
    }

    @RequestMapping("/header")
    public String getHeader() throws InterruptedException {

        return "header";
    }

    @Bean
    public RequestHeaderFilter changeRequestHeaderFilter() {
        return new RequestHeaderFilter();
    }
}
