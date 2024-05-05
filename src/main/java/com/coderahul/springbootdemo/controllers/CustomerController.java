package com.coderahul.springbootdemo.controllers;

import com.coderahul.springbootdemo.models.Customer;
import com.coderahul.springbootdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable Long id){
        Customer customer = customerService.getCustomer(id);
        if(customer==null){
            return new ResponseEntity<>(new Customer(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Customer>> getCustomers(){
        List<Customer> customers = customerService.getAllCustomer();
        if(customers==null){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Customer> addCustomers(@RequestBody Customer customer){
        customer = customerService.addCustomer(customer);
        if(customer==null){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

}
