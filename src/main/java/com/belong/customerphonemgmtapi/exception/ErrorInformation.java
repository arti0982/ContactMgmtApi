package com.belong.customerphonemgmtapi.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorInformation {
    private String message;
    private String exception;

    public ErrorInformation(String message, Exception ex) {
        this.message = message;
        if (ex != null) {
            this.exception = ex.getLocalizedMessage();
        }
    }
}
