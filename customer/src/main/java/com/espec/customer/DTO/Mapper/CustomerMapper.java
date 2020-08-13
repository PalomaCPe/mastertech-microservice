package com.espec.customer.DTO.Mapper;

import com.espec.customer.DTO.Request.CustomerRequest;
import com.espec.customer.DTO.Response.CustomerResponse;
import com.espec.customer.model.Customer;
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
}
