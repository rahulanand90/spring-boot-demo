package com.coderahul.springbootdemo.service;

import com.coderahul.springbootdemo.exceptions.AddressNotFoundException;
import com.coderahul.springbootdemo.models.Address;
import com.coderahul.springbootdemo.models.Customer;
import com.coderahul.springbootdemo.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    private static final String ADDRESS_NOT_FOUND = "Address could not be found";

    private final AddressRepository addressRepository;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Address getAddress(Long id) {
        return addressRepository.findById(id).orElseThrow(() -> new AddressNotFoundException(ADDRESS_NOT_FOUND));
    }

    @Override
    public List<Address> getAllAddressByCustomer(Customer customer) {
        return List.of();
    }

    @Override
    public Address addAddress(Address address) {
        return addressRepository.save(address);
    }
}
