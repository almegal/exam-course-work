package com.example.examcoursework.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.METHOD_NOT_ALLOWED)
public class ExceptionMethodNotAlowed extends RuntimeException {
    public ExceptionMethodNotAlowed(String message) {
        super(message);
    }
}
