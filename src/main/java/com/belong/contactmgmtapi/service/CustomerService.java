package com.belong.contactmgmtapi.service;

import com.belong.contactmgmtapi.exception.ResourceNotFoundException;
import com.belong.contactmgmtapi.model.Customer;
import com.belong.contactmgmtapi.model.PhoneNumber;
import org.springframework.stereotype.Service;
import com.belong.contactmgmtapi.util.StaticCustomerPhoneData;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    public List<Customer> getAllCustomerDetails() {
        List<Customer> customers = new ArrayList<>();
        StaticCustomerPhoneData.CONTACT_MAP.forEach((key, value) -> {
            customers.add(value);
        });
        return customers;
    }

    public List<String> getPhoneNumbersByCustomer(String customerId) {
        if ( StaticCustomerPhoneData.CONTACT_MAP.get(customerId) == null)
            throw new ResourceNotFoundException("Could not find customer for customer id '" + customerId + "'");
        return StaticCustomerPhoneData.CONTACT_MAP.get(customerId).getPhoneNumbers().stream().map(PhoneNumber::getNumber).toList();
    }

    public List<String> getAllPhoneNumbers() {
        List<String> phoneNumbers = new ArrayList<>();
        StaticCustomerPhoneData.CONTACT_MAP.forEach((key, value) -> {
            phoneNumbers.addAll(value.getPhoneNumbers().stream().map(PhoneNumber::getNumber).toList());
        });
        return phoneNumbers;
    }

    public PhoneNumber activateCustomerPhoneNumber(String customerId, String customerPhoneNumber) {
        if ( StaticCustomerPhoneData.CONTACT_MAP.get(String.valueOf(customerId)) == null)
            throw new ResourceNotFoundException("Could not find the customer for customer id '" + customerId + "'");

        PhoneNumber phoneNumberToActivate = StaticCustomerPhoneData.CONTACT_MAP.get(customerId).getPhoneNumbers().stream()
                .filter(phoneNumber -> phoneNumber.getNumber().equals(customerPhoneNumber))
                .findFirst().orElseThrow(() -> new ResourceNotFoundException("Could not find phone number '" + customerPhoneNumber + "' for the customer id '" + customerId + "'"));
        phoneNumberToActivate.setActive(true);
        return phoneNumberToActivate;
    }
}
