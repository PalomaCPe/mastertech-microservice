package com.espec.customer.controller;

import com.espec.customer.DTO.Mapper.CustomerMapper;
import com.espec.customer.model.Customer;
import com.espec.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/cliente")
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
        try{
            Customer customer = customerService.findById(id);
            return customer;
        }catch (RuntimeException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

}
