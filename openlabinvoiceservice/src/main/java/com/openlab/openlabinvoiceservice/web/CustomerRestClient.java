package com.openlab.openlabinvoiceservice.web;


import com.openlab.openlabinvoiceservice.configs.FeignClientConfig;
import com.openlab.openlabinvoiceservice.entities.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@FeignClient(name = "CUSTOMER-SERVICE", configuration = FeignClientConfig.class, url = "${feign.client.post.baseUrl}")
public interface CustomerRestClient {
    @GetMapping(path = "/api/customers")
    //@RequestMapping(method = RequestMethod.GET, value = "/api/customers")
    List<Customer> allCustomers();

    @GetMapping(path = "/api/customers/{id}")
    //@RequestMapping(method = RequestMethod.POST, value = "/api/customers/{id}")
    Customer getCustomer(@PathVariable(name = "id") String id);
}
