package com.espec.card.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "CUSTOMER", configuration = CustomerClientConfiguration.class)
public interface CustomerClient {
    @GetMapping("/customer/{id}")
    Customer findById(@PathVariable int id);
}
