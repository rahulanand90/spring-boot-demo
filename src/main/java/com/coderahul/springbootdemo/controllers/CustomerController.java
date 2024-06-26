package com.coderahul.springbootdemo.controllers;

import com.coderahul.springbootdemo.models.Customer;
import com.coderahul.springbootdemo.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@Tag(name = "Customer")
public class CustomerController {

    //  @Value("${server.port}")
    // private String serverPort;

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Operation(
            description = "Get Customer by Customer ID",
            summary = "Get Customer by Customer ID",
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200"),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500")
            }
    )

    // @GetMapping("/{id}")
    @RequestMapping(value = "/{id}", method = {RequestMethod.GET}) // also this
    public ResponseEntity<Customer> getCustomer(@PathVariable Long id) {
        return new ResponseEntity<>(customerService.getCustomer(id), HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Customer>> getCustomers() {
        return new ResponseEntity<>(customerService.getAllCustomer(), HttpStatus.OK);
    }

    @Operation(
            description = "Save Customer details",
            summary = "Save Customer details",
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200"),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = {}),
                    @ApiResponse(description = "Bad Request", responseCode = "400", useReturnTypeSchema = false)
            }
    )
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Customer> addCustomers(@RequestBody Customer customer) {
        return new ResponseEntity<>(customerService.addCustomer(customer), HttpStatus.OK);
    }

}
