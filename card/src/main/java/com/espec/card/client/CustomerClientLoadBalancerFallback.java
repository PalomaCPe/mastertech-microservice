package com.espec.card.client;

import com.netflix.client.ClientException;
import feign.FeignException;

public class CustomerClientLoadBalancerFallback implements CustomerClient {

    private Exception exception;

    public CustomerClientLoadBalancerFallback(Exception exception) {
        this.exception = exception;
    }

    @Override
    public Customer findById(int id) {
        if(exception.getCause() instanceof ClientException) {
            Customer customer = new Customer();
            customer.setName("Falha em comunicação com o MS de cliente");
            return customer;
        }
        throw (RuntimeException) exception;
    }
}