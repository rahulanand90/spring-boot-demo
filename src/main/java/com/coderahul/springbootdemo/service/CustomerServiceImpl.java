package com.coderahul.springbootdemo.service;

import com.coderahul.springbootdemo.models.Customer;
import com.coderahul.springbootdemo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer getCustomer(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        return customer.orElse(null);
    }

    @Override
    public List<Customer> getAllCustomer() {
        return (List<Customer>) customerRepository.findAll();
    }

}
