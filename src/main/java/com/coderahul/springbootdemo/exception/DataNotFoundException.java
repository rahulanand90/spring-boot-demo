package com.coderahul.springbootdemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NO_CONTENT)
public class DataNotFoundException extends RuntimeException{
    public DataNotFoundException(String msg) {
        super(msg);
    }
}
