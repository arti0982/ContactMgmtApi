package com.belong.contactmgmtapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)  // 404
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseBody
    public ErrorInformation handleNotFound(ResourceNotFoundException e) {
        return new ErrorInformation("Object not found", e);
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)  // 403
    @ExceptionHandler(ForbiddenException.class)
    @ResponseBody
    public ErrorInformation handleForbidden(ForbiddenException e) {
        return new ErrorInformation("Forbidden", e);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)  // 500
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ErrorInformation handleOtherException(Exception e) {
        return new ErrorInformation("Internal server error", e);
    }



}
