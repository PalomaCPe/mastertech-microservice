package com.ex1cartoesapi.DTO.Mapper;

import com.ex1cartoesapi.DTO.Request.CustomerRequest;
import com.ex1cartoesapi.DTO.Response.CustomerResponse;
import com.ex1cartoesapi.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {
    public Customer toCustomer(CustomerRequest customerRequest){
        Customer customer = new Customer();
        customer.setName(customerRequest.getName());
        return customer;
    }

    public CustomerResponse toCustomerResponse(Customer customer) {
        CustomerResponse customerResponse = new CustomerResponse();
        customerResponse.setId(customer.getId());
        customerResponse.setName(customer.getName());
        return customerResponse;
    }

    public CustomerResponse toCustomerDetalheResponse(Customer customer) {
        CustomerResponse customerDetalheResponse = new CustomerResponse();
        customerDetalheResponse.setId(customer.getId());
        customerDetalheResponse.setName(customer.getName());
        return customerDetalheResponse;
    }
}
