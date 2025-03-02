package com.belong.customerphonemgmtapi.controller;


import com.belong.customerphonemgmtapi.model.Customer;
import com.belong.customerphonemgmtapi.model.PhoneNumber;
import com.belong.customerphonemgmtapi.service.CustomerService;
import com.belong.customerphonemgmtapi.validator.CustomerPhoneNumberRestValidator;
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
public class CustomerMgmtController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerPhoneNumberRestValidator validator;

    @Operation(summary = "Get all the available phone numbers")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "List of phone numbers")})
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<String>> getAllPhoneNumbers() {

        return new ResponseEntity<>(customerService.getAllPhoneNumbers(), HttpStatus.OK);
    }

    @Operation(summary = "Get phone numbers assigned to a customer")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of phone numbers of a customer"),
            @ApiResponse(responseCode = "404", description = "Customer not found"),
            @ApiResponse(responseCode = "400", description = "Invalid format of customerID")
    })
    @RequestMapping(value = "/customers/{customerId}/phone-numbers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<String>> getCustomerPhoneNumbers(@PathVariable String customerId) {
        validator.validateCustomerId(customerId);
        List<String> phoneNumbers = customerService.getPhoneNumbersByCustomer(customerId);
        return new ResponseEntity<>(phoneNumbers, HttpStatus.OK);
    }

    @Operation(summary = "Activate a phone number assigned to a customer")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Activate the phone number of a customer"),
            @ApiResponse(responseCode = "404", description = "Customer or phone number not found"),
            @ApiResponse(responseCode = "400", description = "Invalid format of customerID and/or phone number")
    })
    @RequestMapping(value="/customers/{customerId}/phone-numbers/{phoneNumber}", method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PhoneNumber> activateCustomerPhoneNumber(@PathVariable String customerId, @PathVariable String phoneNumber) {

        validator.validateCustomerId(customerId);
        validator.validatePhoneNumber(phoneNumber);
        PhoneNumber phoneNumberActivated = this.customerService.activateCustomerPhoneNumber(customerId, phoneNumber);
        return new ResponseEntity<>(phoneNumberActivated,HttpStatus.OK);
    }

}

