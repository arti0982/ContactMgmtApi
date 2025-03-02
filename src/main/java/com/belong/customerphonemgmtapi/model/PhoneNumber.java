package com.belong.customerphonemgmtapi.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PhoneNumber {

    @Schema(description = "Unique phone number")
    private String number;

    @Schema(description = "Identifies if the phone number is ACTIVE")
    private boolean active;
}
