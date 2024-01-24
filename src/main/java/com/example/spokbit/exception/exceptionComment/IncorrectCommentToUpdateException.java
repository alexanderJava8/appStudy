package com.example.spokbit.exception.exceptionComment;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class IncorrectCommentToUpdateException extends RuntimeException {
    public IncorrectCommentToUpdateException(String message) {
        super(message);
    }   
}
