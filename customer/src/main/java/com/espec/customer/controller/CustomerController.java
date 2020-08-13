package com.ex1cartoesapi.controller;

import com.ex1cartoesapi.model.Customer;
import com.ex1cartoesapi.service.CustomerService;
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

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Customer saveCustomer(@RequestBody @Valid Customer customer) {
        return customerService.save(customer);
    }

    @GetMapping("/{id}")
    public Customer findCustomerById(@PathVariable(name = "id") int id){
        try{
            Customer customer = customerService.findById(id);
            return customer;
        }catch (RuntimeException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

}
