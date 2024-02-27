package com.example.spokbit.exception.exceptionVideo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class IncorrectVideoRequestException extends RuntimeException {
    public IncorrectVideoRequestException(String message) {
        super(message);
    }
}
