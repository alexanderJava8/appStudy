package com.example.spokbit.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundTopicExceptions extends RuntimeException {
    public NotFoundTopicExceptions(String message) {
        super(message);
    }
}
