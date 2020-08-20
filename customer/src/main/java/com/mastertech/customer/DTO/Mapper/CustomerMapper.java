package com.mastertech.customer.DTO.Mapper;

import com.mastertech.customer.DTO.Request.CustomerRequest;
import com.mastertech.customer.DTO.Response.CustomerResponse;
import com.mastertech.customer.model.Customer;
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
