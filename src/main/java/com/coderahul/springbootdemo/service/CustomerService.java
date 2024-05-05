package com.coderahul.springbootdemo.service;

import com.coderahul.springbootdemo.models.Customer;

import java.util.List;

public interface CustomerService {
    Customer getCustomer(Long id);
    List<Customer> getAllCustomer();
}
