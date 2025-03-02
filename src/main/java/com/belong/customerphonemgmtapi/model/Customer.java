package com.belong.customerphonemgmtapi.model;

import io.swagger.v3.oas.annotations.media.Schema;
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
    @Schema(description = "Unique identifier of the customer")
    private Long customerId;

    @Schema(description = "First name of the customer")
    private String firstName;

    @Schema(description = "Last Name of the customer")
    private String lastName;

    @Schema(description = "List of phone numbers associated with the customer")
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
