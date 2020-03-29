package com.zmhomecn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ShangpinApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShangpinApplication.class);
        System.out.println("启动成");
    }

}
