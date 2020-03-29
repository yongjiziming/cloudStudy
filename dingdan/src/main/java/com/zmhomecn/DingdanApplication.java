package com.zmhomecn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
@EnableFeignClients
public class DingdanApplication {

    public static void main(String[] args) {
        SpringApplication.run(DingdanApplication.class);
        System.out.println("启动成功");
    }

    /**
     * 向Spring容器中定义RestTemplate对象
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        //return new RestTemplate();
        return new RestTemplate(new OkHttp3ClientHttpRequestFactory());
    }
}
