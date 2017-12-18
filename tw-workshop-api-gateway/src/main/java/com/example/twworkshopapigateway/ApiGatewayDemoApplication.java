package com.example.twworkshopapigateway;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
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



//    @Bean
//    public ZuulFallbackProvider zuulFallbackProvider() {
//        return new ZuulFallbackProvider() {
//            @Override
//            public String getRoute() {
//                return "zuulserver";
//            }
//
//            @Override
//            public ClientHttpResponse fallbackResponse() {
//                return new ClientHttpResponse() {
//                    @Override
//                    public HttpStatus getStatusCode() throws IOException {
//                        return HttpStatus.OK;
//                    }
//
//                    @Override
//                    public int getRawStatusCode() throws IOException {
//                        return 200;
//                    }
//
//                    @Override
//                    public String getStatusText() throws IOException {
//                        return "OK";
//                    }
//
//                    @Override
//                    public void close() {
//
//                    }
//
//                    @Override
//                    public InputStream getBody() throws IOException {
//                        return new ByteArrayInputStream("fallback".getBytes());
//                    }
//
//                    @Override
//                    public HttpHeaders getHeaders() {
//                        HttpHeaders headers = new HttpHeaders();
//                        headers.setContentType(MediaType.APPLICATION_JSON);
//                        return headers;
//                    }
//                };
//            }
//        };
//    }

}
