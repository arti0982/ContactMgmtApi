package com.belong.customerphonemgmtapi.validator;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.regex.Pattern;

@Component
public class CustomerPhoneNumberRestValidator {
    private static final Pattern VALID_PHONE_NUMBER = Pattern.compile("^0\\d{9}$");

    public void validateCustomerId(String customerId) {
        try {
            if (customerId == null || Long.parseLong(customerId) <= 0) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid customer ID value.");
            }
        } catch (NumberFormatException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid customer ID value.");
        }
    }

    public void validatePhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.trim().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Phone number cannot be null or empty.");
        }

        if (!VALID_PHONE_NUMBER.matcher(phoneNumber).matches()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid phone number format. Accepts a 10 digit number starting with 0.");
        }
    }

}
