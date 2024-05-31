package com.coderahul.springbootdemo.service;

import com.coderahul.springbootdemo.models.Address;
import com.coderahul.springbootdemo.models.Customer;
import com.coderahul.springbootdemo.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Address getAddress(Long id) {
        Optional<Address> address = addressRepository.findById(id);
        return address.orElse(null);
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
