package com.coderahul.springbootdemo.controllers;

import com.coderahul.springbootdemo.models.Address;
import com.coderahul.springbootdemo.service.AddressService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@Tag(name = "Address")
@RequestMapping("/address")
public class AddressController {

    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> getCustomer(@PathVariable Long id){
        Address address = addressService.getAddress(id);
        if(address==null){
            return new ResponseEntity<>(new Address(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(address, HttpStatus.OK);
    }

    @Operation(
            description = "Save Address details",
            summary = "Save Address details",
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200"),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500"),
                    @ApiResponse(description = "Bad Request", responseCode = "400")
            }
    )
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Address> addCustomers(@RequestBody Address address){
        address = addressService.addAddress(address);
        if(address==null){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(address, HttpStatus.OK);
    }
}
