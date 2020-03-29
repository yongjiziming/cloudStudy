package com.zmhomecn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ZmConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZmConfigApplication.class);
        System.out.println("启动成功");
        System.out.println("git");
    }
}
