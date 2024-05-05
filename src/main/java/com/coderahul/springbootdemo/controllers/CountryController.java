package com.coderahul.springbootdemo.controllers;

import com.coderahul.springbootdemo.entities.Country;
import com.coderahul.springbootdemo.exception.DataNotFoundException;
import com.coderahul.springbootdemo.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/country")
public class CountryController {
    @Autowired
    private CountryService countryService;

    //get country list
    @GetMapping()
    public ResponseEntity<List<Country>> getCountryList() {
        List<Country> countryList = countryService.getCountryList();
        if (countryList.size() <= 0) {
            System.out.println(countryList);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(countryList);
    }

    //get country list
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Country>> getCountryById(@PathVariable("id") UUID id) {
        try {
            Optional<Country> country = countryService.getCountryById(id);
            return ResponseEntity.status(HttpStatus.OK).body(country);
        } catch(DataNotFoundException e){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @PostMapping()
    public ResponseEntity<String> addCountry(@RequestBody Country country) {
        try {
            this.countryService.addCountry(country);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCountryById(@PathVariable("id") UUID id) {
        try {
            this.countryService.deleteCountryById(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch(DataNotFoundException e){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }
}
