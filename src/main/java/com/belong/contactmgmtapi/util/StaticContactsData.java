package com.belong.contactmgmtapi.util;

import com.belong.contactmgmtapi.model.Contact;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StaticContactsData {
    public static final Map<String, Contact> CONTACT_MAP = new HashMap<>();

    static {
        CONTACT_MAP.put("12345", new Contact(12345, "FN1", "LN1", List.of("1236000432"), "abcd1234@gmail.com", "N"));
        CONTACT_MAP.put("123456", new Contact(123456, "FN2", "LN2", List.of("2312453212", "2345678908"), "abcde12345@gmail.com", "Y"));
        CONTACT_MAP.put("1234567", new Contact(1234567, "FN3", "LN3", List.of("1236123432","2312499012", "2345600908"), "abcdef123456@gmail.com", "N"));
    }
}
