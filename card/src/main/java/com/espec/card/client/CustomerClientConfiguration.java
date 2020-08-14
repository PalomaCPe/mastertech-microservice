package com.espec.card.client;

import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;


public class CustomerClientConfiguration {
    @Bean
    public ErrorDecoder getCustomerClientDecoder(){
        return new CustomerClientDecoder();
    }

}
