package com.example.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class VersionNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(VersionNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String VersionNotFoundHandler(VersionNotFoundException ex){
        return ex.getMessage();
    }

}
