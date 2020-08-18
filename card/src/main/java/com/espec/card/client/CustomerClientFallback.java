package com.espec.card.client;

public class CustomerClientFallback implements CustomerClient {
    @Override
    public Customer findById(int id) {
        Customer customer = new Customer();
        customer.setId(id);

        return customer;
    }
}