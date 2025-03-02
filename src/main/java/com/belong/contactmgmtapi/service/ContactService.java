package com.belong.contactmgmtapi.service;

import com.belong.contactmgmtapi.exception.ResourceNotFoundException;
import com.belong.contactmgmtapi.model.Contact;
import org.springframework.stereotype.Service;
import com.belong.contactmgmtapi.util.StaticContactsData;

import java.util.List;

@Service
public class ContactService {

    public void getAllContacts(List<Contact> contacts) {
        StaticContactsData.CONTACT_MAP.forEach((key, value) -> {
            contacts.add(value);
        });
    }

    public List<String> getPhoneNumbersById(String customerId) {
        if ( StaticContactsData.CONTACT_MAP.get(customerId) == null)
            throw new ResourceNotFoundException("Could not find contact for customer id '" + customerId + "'");
        return StaticContactsData.CONTACT_MAP.get(customerId).getPhoneNumbers();
    }

    public void getAllPhoneNumbers(List<String> phoneNumbers) {
        StaticContactsData.CONTACT_MAP.forEach((key, value) -> {
            phoneNumbers.addAll(value.getPhoneNumbers().stream().toList());
        });
    }

    public void updateCustomerActiveFlag(Contact contact) {
        if ( StaticContactsData.CONTACT_MAP.get(String.valueOf(contact.getCustomerId())) == null)
            throw new ResourceNotFoundException("Could not find contact for customer id '" + contact.getCustomerId() + "'");
        StaticContactsData.CONTACT_MAP.get(String.valueOf(contact.getCustomerId())).setActive(contact.getActive());
    }
}
