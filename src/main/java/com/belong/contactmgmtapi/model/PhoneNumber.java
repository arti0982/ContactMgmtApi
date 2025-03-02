package com.belong.contactmgmtapi.model;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PhoneNumber {

    private String number;

    private String active;
}
