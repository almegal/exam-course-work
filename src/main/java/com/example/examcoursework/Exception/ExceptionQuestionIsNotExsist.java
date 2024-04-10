package com.example.examcoursework.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class ExceptionQuestionIsNotExsist extends RuntimeException {
    public ExceptionQuestionIsNotExsist(String message) {
        super(message);
    }
}
