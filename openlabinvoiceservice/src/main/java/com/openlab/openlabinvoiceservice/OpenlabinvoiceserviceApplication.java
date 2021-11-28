package com.openlab.openlabinvoiceservice;

import com.openlab.openlabinvoiceservice.dto.InvoiceRequestDTO;
import com.openlab.openlabinvoiceservice.services.InvoiceService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;


@SpringBootApplication
@EnableFeignClients
public class OpenlabinvoiceserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpenlabinvoiceserviceApplication.class, args);
    }



    @Bean
    CommandLineRunner start(InvoiceService invoiceService){
        return  args -> {
            invoiceService.save(new InvoiceRequestDTO("CB01", BigDecimal.valueOf(400000)));
            invoiceService.save(new InvoiceRequestDTO("CB01", BigDecimal.valueOf(84130)));
            invoiceService.save(new InvoiceRequestDTO("CB01", BigDecimal.valueOf(5000)));
            invoiceService.save(new InvoiceRequestDTO("CB02", BigDecimal.valueOf(155000)));
        };
    }

}
