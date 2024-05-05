package com.coderahul.springbootdemo.repository;

import com.coderahul.springbootdemo.models.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
