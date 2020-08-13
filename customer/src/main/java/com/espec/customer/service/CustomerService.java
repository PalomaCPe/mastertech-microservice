package com.ex1cartoesapi.service;

import com.ex1cartoesapi.model.Customer;
import com.ex1cartoesapi.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer findById(int id){
        Optional<Customer> customerOptional = customerRepository.findById(id);

        if(customerOptional.isPresent()){
            Customer customer = customerOptional.get();
            return  customer;
        }else {
            throw new RuntimeException("Not found");
        }
    }

}
