package com.openlab.openlabdiscoveryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class OpenlabdiscoveryserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpenlabdiscoveryserviceApplication.class, args);
    }

}
