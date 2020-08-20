package com.mastertech.customer.service;

import com.mastertech.customer.repository.CustomerRepository;
import com.mastertech.customer.exception.CustomerNotFoundException;
import com.mastertech.customer.model.Customer;
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
