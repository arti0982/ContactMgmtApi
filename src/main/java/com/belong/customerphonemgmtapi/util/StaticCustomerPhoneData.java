package com.belong.customerphonemgmtapi.util;

import com.belong.customerphonemgmtapi.model.Customer;
import com.belong.customerphonemgmtapi.model.PhoneNumber;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StaticCustomerPhoneData {
    public static final Map<String, Customer> CONTACT_MAP = new HashMap<>();

    static {
        CONTACT_MAP.put("12345", new Customer(Long.valueOf("12345"), "FN1", "LN1", List.of(new PhoneNumber("0431234567", false)), "abcd1234@gmail.com"));
        CONTACT_MAP.put("123456", new Customer(Long.valueOf("123456"), "FN2", "LN2", List.of(new PhoneNumber("0431230067", false), new PhoneNumber("0431299567", false)), "abcde12345@gmail.com"));
        CONTACT_MAP.put("1234567", new Customer(Long.valueOf("1234567"), "FN3", "LN3", List.of(new PhoneNumber("0432334567", false), new PhoneNumber("0431221567", false), new PhoneNumber("0431784567", false)), "abcdef123456@gmail.com"));
    }
}
