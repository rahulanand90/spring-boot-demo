package com.coderahul.springbootdemo.controllers;

import com.coderahul.springbootdemo.models.Address;
import com.coderahul.springbootdemo.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/address")
public class AddressController {

    private final AddressRepository addressRepository;

    @Autowired
    public AddressController(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @GetMapping("/{id}")
    public Optional<Address> getStudent(@PathVariable Integer id){
        return addressRepository.findById(id);
    }

    @GetMapping("/all")
    public List<Address> getStudent(){
        return (List<Address>) addressRepository.findAll();
    }
}
