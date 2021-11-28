package com.openlab.openlabcustomerservice.web;

import com.openlab.openlabcustomerservice.dto.CustomerRequestDTO;
import com.openlab.openlabcustomerservice.dto.CustomerResponseDTO;
import com.openlab.openlabcustomerservice.services.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api")
public class CustomerRestAPI {
   private CustomerService customerService;

    public CustomerRestAPI(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(path = "customers")
    public List<CustomerResponseDTO> allCustomer(){
        return  customerService.listCustomers();
    }

    @PostMapping(path = "customers")
    public CustomerResponseDTO save(CustomerRequestDTO customerRequestDTO){
        return  customerService.save(customerRequestDTO);
    }

    @PutMapping(path = "customers")
    public CustomerResponseDTO updateCustomer(CustomerRequestDTO customerRequestDTO){
        return  customerService.update(customerRequestDTO);
    }

    @GetMapping(path = "customers/{id}")
    public CustomerResponseDTO getCustomer(@PathVariable String id){
        return  customerService.getCustomer(id);
    }
}
