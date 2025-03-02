package com.belong.contactmgmtapi.controller;


import com.belong.contactmgmtapi.model.Contact;
import com.belong.contactmgmtapi.service.ContactService;
import com.belong.contactmgmtapi.util.StaticContactsData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping ("/contact")
public class ContactsController {

    @Autowired
    private ContactService contactService;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Contact>> findAllContacts() {
        List<Contact> contacts = new ArrayList<>();
//        StaticContactsData.CONTACT_MAP.forEach((key, value) -> {
//            contacts.add(value);
//        });
        contactService.getAllContacts(contacts);
        System.out.println("Retrieved contacts are: " + contacts);
        return new ResponseEntity<>(contacts, HttpStatus.OK);
    }

    @RequestMapping(value = "/{customerId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<String>> findCustomerPhoneNumbers(@PathVariable String customerId) {
        List<String> phoneNumbers;
        phoneNumbers = contactService.getPhoneNumbersById(customerId);
//      StaticContactsData.CONTACT_MAP.get(customerId) != null ? StaticContactsData.CONTACT_MAP.get(customerId).getPhoneNumbers() : null;
        System.out.println("Retrieved phoneNumbers are: " + phoneNumbers);
        return new ResponseEntity<>(phoneNumbers, HttpStatus.OK);
    }

    @RequestMapping(value = "/numbers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<String>> findAllPhoneNumbers() {
        List<String> phoneNumbers = new ArrayList<>();
//        StaticContactsData.CONTACT_MAP.forEach((key, value) -> {
//            phoneNumbers.addAll(value.getPhoneNumbers().stream().toList());
//        });
        contactService.getAllPhoneNumbers(phoneNumbers);
        System.out.println("Retrieved phoneNumbers are: " + phoneNumbers);
        return new ResponseEntity<>(phoneNumbers, HttpStatus.OK);
    }

    @RequestMapping(value="/{customerId}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Contact> updateCustomerActiveFlag(@PathVariable String customerId, @RequestBody Contact contact) {
        contact.setCustomerId(Long.parseLong(customerId));
        contact.setActive("Y");
        this.contactService.updateCustomerActiveFlag(contact);
        System.out.println("updated Contact data for customer: " + customerId);
        return new ResponseEntity<>(contact, HttpStatus.OK);
    }

}
