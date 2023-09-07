package com.example.spokbit.exception.exceptionComment;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class IncorrectCommentRequestException extends RuntimeException {
    public IncorrectCommentRequestException(String message) {
        super(message);
    }
}
