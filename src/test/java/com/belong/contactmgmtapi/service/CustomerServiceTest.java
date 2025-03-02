package com.belong.contactmgmtapi.service;

import com.belong.contactmgmtapi.exception.ResourceNotFoundException;
import com.belong.contactmgmtapi.util.StaticCustomerPhoneData;
import com.belong.contactmgmtapi.validator.CustomerPhoneNumberRestValidator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {

    @InjectMocks
    private CustomerService customerService ;

    @InjectMocks
    private CustomerPhoneNumberRestValidator customerPhoneNumberRestValidator;

    @AfterEach
    void tearDown() {
    }


    @Test
    void getPhoneNumbersByCustomer_shouldReturnListOfPhoneNumbers() {

        List<String> phoneNumbers = customerService.getPhoneNumbersByCustomer("123456");

        assertFalse(phoneNumbers.isEmpty());
        assertEquals(2, phoneNumbers.size());
        assertTrue(phoneNumbers.contains("0431230067"));
        assertTrue(phoneNumbers.contains("0431299567"));
    }

    @Test
    void getAllPhoneNumbers_shouldReturnListOfPhoneNumbers() {

        List<String> phoneNumbers = customerService.getAllPhoneNumbers();

        assertEquals(6, phoneNumbers.size());
        assertTrue(phoneNumbers.contains("0431230067"));
        assertTrue(phoneNumbers.contains("0431299567"));

    }

    @Test
    void activateCustomerPhoneNumber_shouldUpdateCustomerPhoneNumber() {
        assertFalse(StaticCustomerPhoneData.CONTACT_MAP.get("12345").getPhoneNumbers().get(0).isActive());

        customerService.activateCustomerPhoneNumber("12345","0431234567");
        assertTrue(StaticCustomerPhoneData.CONTACT_MAP.get("12345").getPhoneNumbers().get(0).isActive());

    }

    @Test
    void activateCustomerPhoneNumber_shouldThrowResourceNotFoundException_whenCustomerNotFound() {

        assertThrows(ResourceNotFoundException.class, () -> customerService.activateCustomerPhoneNumber("111", "0431234567"));

    }

    @Test
    void activateCustomerPhoneNumber_shouldThrowResourceNotFoundException_whenPhoneNumberNotFound() {

        assertThrows(ResourceNotFoundException.class, () -> customerService.activateCustomerPhoneNumber("12345", "12323434"));

    }

    @Test
    void validateCustomerId_shouldThrowRResponseStatusException_whenCustomerIdIsInvalid() {

        assertThrows(ResponseStatusException.class, () -> customerPhoneNumberRestValidator.validateCustomerId("abcd"));

    }

    @Test
    void validateCustomerId_shouldThrowRResponseStatusException_whenPhoneNumberIsInvalid() {

        assertThrows(ResponseStatusException.class, () -> customerPhoneNumberRestValidator.validatePhoneNumber("12323434"));

    }

}