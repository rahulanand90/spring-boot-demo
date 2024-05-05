package com.coderahul.springbootdemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.ALREADY_REPORTED)
public class DuplicateDataException extends RuntimeException {
    public DuplicateDataException(String msg) {
        super(msg);
    }
}
