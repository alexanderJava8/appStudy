package com.example.spokbit.exception.exceptionTopic;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class IncorrectTopicRequestException extends RuntimeException {
    public IncorrectTopicRequestException(String message) {
        super(message);
    }
}
