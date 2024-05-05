package com.coderahul.springbootdemo.repository;

import com.coderahul.springbootdemo.models.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Integer> {
}
