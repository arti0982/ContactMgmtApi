package com.belong.contactmgmtapi.controller;


import com.belong.contactmgmtapi.model.Customer;
import com.belong.contactmgmtapi.service.CustomerService;
import com.belong.contactmgmtapi.validator.CustomerPhoneNumberRestValidator;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/")
@ControllerAdvice
public class ContactsController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerPhoneNumberRestValidator validator;

    @Operation(summary = "Get all the available phone numbers")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "List of phone numbers")})
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<String>> getAllPhoneNumbers() {
        List<String> phoneNumbers;
        phoneNumbers = customerService.getAllPhoneNumbers();
        System.out.println("Retrieved phoneNumbers are: " + phoneNumbers);
        return new ResponseEntity<>(phoneNumbers, HttpStatus.OK);
    }

    @Operation(summary = "Get phone numbers assigned to a customer")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of phone numbers of a customer"),
            @ApiResponse(responseCode = "404", description = "Customer not found"),
            @ApiResponse(responseCode = "400", description = "Invalid format of customerID")
    })
    @RequestMapping(value = "/customers/{customerId}/phone-numbers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<String>> getCustomerPhoneNumbers(@PathVariable String customerId) {
        List<String> phoneNumbers;
        validator.validateCustomerId(Long.valueOf(customerId));
        phoneNumbers = customerService.getPhoneNumbersByCustomer(customerId);
        System.out.println("Retrieved phoneNumbers are: " + phoneNumbers);
        return new ResponseEntity<>(phoneNumbers, HttpStatus.OK);
    }

    @Operation(summary = "Activate a phone number assigned to a customer")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Activate the phone number of a customer"),
            @ApiResponse(responseCode = "404", description = "Customer or phone number not found"),
            @ApiResponse(responseCode = "400", description = "Invalid format of customerID and/or phone number")
    })
    @RequestMapping(value="/customers/{customerId}/phone-numbers/{phoneNumber}", method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> activateCustomerPhoneNumber(@PathVariable String customerId, @PathVariable String phoneNumber) {

        validator.validateCustomerId(Long.valueOf(customerId));
        validator.validatePhoneNumber(phoneNumber);
        this.customerService.activateCustomerPhoneNumber(customerId, phoneNumber);
        System.out.println("updated phone number: "+phoneNumber+ " for customer: " + customerId);
        return new ResponseEntity<>("Phone Number Activated",HttpStatus.OK);
    }

    @Operation(summary = "List customer contact details of all customers ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "list of customer contact details of all customer")
    })
    @RequestMapping(value="/customers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Customer>> getAllCustomerDetails() {
        List<Customer> customers;
        customers = customerService.getAllCustomerDetails();
        System.out.println("Retrieved customers are: " + customers);
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

}
