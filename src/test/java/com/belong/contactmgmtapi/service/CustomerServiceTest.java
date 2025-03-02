package com.belong.contactmgmtapi.service;

import com.belong.contactmgmtapi.exception.ResourceNotFoundException;
import com.belong.contactmgmtapi.util.StaticContactsData;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {

    @InjectMocks
    private CustomerService customerService ;//= new CustomerService();

    @AfterEach
    void tearDown() {
    }


    @Test
    void getPhoneNumbersByCustomer_shouldReturnListOfPhoneNumbers() {

        List<String> phoneNumbers = customerService.getPhoneNumbersByCustomer("123456");

        assertFalse(phoneNumbers.isEmpty());
        assertEquals(2, phoneNumbers.size());
        assertTrue(phoneNumbers.contains("1236020432"));
        assertTrue(phoneNumbers.contains("1236222432"));
    }

    @Test
    void getAllPhoneNumbers_shouldReturnListOfPhoneNumbers() {

        List<String> phoneNumbers = customerService.getAllPhoneNumbers();

        assertEquals(6, phoneNumbers.size());
        assertTrue(phoneNumbers.contains("1236020432"));
        assertTrue(phoneNumbers.contains("1236020432"));

    }

    @Test
    void activateCustomerPhoneNumber_shouldUpdateCustomerPhoneNumber() {
        assertEquals("N", StaticContactsData.CONTACT_MAP.get("12345").getPhoneNumbers().get(0).getActive());

        customerService.activateCustomerPhoneNumber("12345","1236000432");
        assertEquals("Y", StaticContactsData.CONTACT_MAP.get("12345").getPhoneNumbers().get(0).getActive());

    }

    @Test
    void activateCustomerPhoneNumber_shouldThrowResourceNotFoundException_whenCustomerNotFound() {

        assertThrows(ResourceNotFoundException.class, () -> customerService.activateCustomerPhoneNumber("111", "12323434"));

    }

    @Test
    void activateCustomerPhoneNumber_shouldThrowResourceNotFoundException_whenPhoneNumberrNotFound() {

        assertThrows(ResourceNotFoundException.class, () -> customerService.activateCustomerPhoneNumber("12345", "12323434"));

    }

    @Test
    void getPhoneNumbersByCustomer_shouldThrowResourceNotFoundException_whenCustomerNotFound() {

        assertThrows(ResourceNotFoundException.class, () -> customerService.getPhoneNumbersByCustomer("111"));

    }
}