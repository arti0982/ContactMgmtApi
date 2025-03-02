package com.belong.contactmgmtapi.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Customer {
    private Long customerId;

    private String firstName;

    private String lastName;

    private List<PhoneNumber> phoneNumbers;

    private String email;

    public Customer(Long customerId, String firstName, String lastName, List<PhoneNumber> phoneNumbers, String email) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumbers = phoneNumbers;
        this.email = email;
    }

}
