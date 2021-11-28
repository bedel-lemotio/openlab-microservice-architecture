package com.openlab.openlabcustomerservice;

import com.openlab.openlabcustomerservice.dto.CustomerRequestDTO;
import com.openlab.openlabcustomerservice.services.CustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OpenlabcustomerserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpenlabcustomerserviceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CustomerService customerService){
        return args -> {
            customerService.save(new CustomerRequestDTO("CB01","Arien","meza@gmail.com"));
            customerService.save(new CustomerRequestDTO("CB02","openLab","lemotiobedel@gmail.com"));
        };
    }

}
