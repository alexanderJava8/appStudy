package com.example.spokbit.exception;

public class IncorrectCommentRequestException extends RuntimeException {
    public IncorrectCommentRequestException(String message) {
        super(message);
    }
}
