package com.coderahul.springbootdemo.controllers;

import com.coderahul.springbootdemo.models.Customer;
import com.coderahul.springbootdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/getCustomer/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable Long id){
        return ResponseEntity.ok(customerService.getCustomer(id));
    }

    @GetMapping("/getAllCustomers")
    public ResponseEntity<List<Customer>> getCustomers(){
        return ResponseEntity.ok(customerService.getAllCustomer());
    }

}
