package com.coderahul.springbootdemo.service;

import com.coderahul.springbootdemo.models.Address;
import com.coderahul.springbootdemo.models.Customer;

import java.util.List;

public interface AddressService {
    Address getAddress(Long id);
    List<Address> getAllAddressByCustomer(Customer customer);
    Address addAddress(Address address);
}
