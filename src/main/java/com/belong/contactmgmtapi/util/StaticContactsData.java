package com.belong.contactmgmtapi.util;

import com.belong.contactmgmtapi.model.Customer;
import com.belong.contactmgmtapi.model.PhoneNumber;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StaticContactsData {
    public static final Map<String, Customer> CONTACT_MAP = new HashMap<>();

    static {
        CONTACT_MAP.put("12345", new Customer(Long.valueOf("12345"), "FN1", "LN1", List.of(new PhoneNumber("1236-000-432", "N")), "abcd1234@gmail.com"));
        CONTACT_MAP.put("123456", new Customer(Long.valueOf("123456"), "FN2", "LN2", List.of(new PhoneNumber("1236-020-432", "N"), new PhoneNumber("1236-222-432", "N")), "abcde12345@gmail.com"));
        CONTACT_MAP.put("1234567", new Customer(Long.valueOf("1234567"), "FN3", "LN3", List.of(new PhoneNumber("1236-440-432", "N"), new PhoneNumber("1236-672-432", "N"), new PhoneNumber("1236-673-332", "N")), "abcdef123456@gmail.com"));
    }
}
