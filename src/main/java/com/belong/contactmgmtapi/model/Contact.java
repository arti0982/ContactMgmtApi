package com.belong.contactmgmtapi.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class Contact {
    private long customerId;

    private String firstName;

    private String lastName;

    private List<String> phoneNumbers;

    private String email;

    private String active ;

    public Contact() {}

    public Contact(long customerId, String firstName, String lastName, String phoneNumber, String email, String active) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        if (phoneNumbers !=null && ! phoneNumbers.contains(phoneNumber)) {
            phoneNumbers.add(phoneNumber);
        }
        this.email = email;
        this.active = active;
    }

    public Contact(long customerId, String firstName, String lastName, List<String> phoneNumbers, String email, String active) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumbers = phoneNumbers;
        this.email = email;
        this.active = active;
    }

}
