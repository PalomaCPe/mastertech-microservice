package com.mastertech.customer.controller;

import com.mastertech.customer.DTO.Mapper.CustomerMapper;
import com.mastertech.customer.service.CustomerService;
import com.mastertech.customer.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @Autowired
    private CustomerMapper customerMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Customer saveCustomer(@RequestBody @Valid Customer customer) {

        return customerService.create(customer);
    }

    @GetMapping("/{id}")
    public Customer findById(@PathVariable(name = "id") int id){
        Customer customer = customerService.findById(id);
        return customer;
    }

}
