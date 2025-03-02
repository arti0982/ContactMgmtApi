package com.belong.contactmgmtapi.validator;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.regex.Pattern;

@Component
public class CustomerPhoneNumberRestValidator {
    private static final Pattern VALID_PHONE_NUMBER = Pattern.compile("^\\d{4}-\\d{3}-\\d{3}$");

    public void validatePhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.trim().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Phone number cannot be null or empty.");
        }

        if (!VALID_PHONE_NUMBER.matcher(phoneNumber).matches()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid phone number format. Use XXXX-XXX-XXX.");
        }
    }

    public void validateCustomerId(Long customerId) {
        if (customerId == null || customerId <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid customer ID value.");
        }
    }
}
