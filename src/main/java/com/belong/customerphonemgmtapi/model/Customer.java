package com.belong.customerphonemgmtapi.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
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


}
