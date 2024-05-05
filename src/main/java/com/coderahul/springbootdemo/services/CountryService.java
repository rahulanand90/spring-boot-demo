package com.coderahul.springbootdemo.services;

import com.coderahul.springbootdemo.entities.Country;
import com.coderahul.springbootdemo.exception.DataNotFoundException;
import com.coderahul.springbootdemo.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CountryService {
    @Autowired
    private CountryRepository countryRepository;

    // get country list
    public List<Country> getCountryList() {
        try {
            return (List<Country>) this.countryRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // adding the book
    public void addCountry(Country country) {
        try {
            countryRepository.save(country);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalArgumentException("Duplicate entry found");
        }
    }

    public Optional<Country> getCountryById(UUID id) {
        try {
            if (countryRepository.existsById(id)) {
                return this.countryRepository.findById(id);
            }
            throw new DataNotFoundException("Data not found");
        } catch (DataNotFoundException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public void deleteCountryById(UUID id) {
        if (countryRepository.existsById(id)) {
            this.countryRepository.deleteById(id);
        }
        throw new DataNotFoundException("Id not found");
    }
}
