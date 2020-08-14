package com.espec.customer.service;

import com.espec.customer.exception.CustomerNotFoundException;
import com.espec.customer.model.Customer;
import com.espec.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Customer create(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer findById(int id){
        Optional<Customer> customerOptional = customerRepository.findById(id);

        if(!customerOptional.isPresent()){
            throw new CustomerNotFoundException();
        }

        return  customerOptional.get();
    }

}
