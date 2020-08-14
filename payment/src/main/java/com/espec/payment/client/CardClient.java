package com.espec.payment.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "CARD", configuration = CardClientConfiguration.class)
public interface CardClient {

    @GetMapping("/{id}")
    Card findById(@PathVariable int id);

}

