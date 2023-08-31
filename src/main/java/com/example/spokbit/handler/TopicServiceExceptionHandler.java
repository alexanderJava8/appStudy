package com.example.spokbit.handler;

import com.example.spokbit.exception.IncorrectTopicRequestException;
import com.example.spokbit.exception.MessageServicesException;
import com.example.spokbit.exception.NotFoundTopicExceptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
@RestController
public class TopicServiceExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAllExceptions(Exception exception, WebRequest request) {
        MessageServicesException response = new MessageServicesException(exception.getMessage(), request.getDescription(false), HttpStatus.INTERNAL_SERVER_ERROR, LocalDateTime.now());
        return new ResponseEntity<>(response, response.httpStatus());
    }

    @ExceptionHandler(IncorrectTopicRequestException.class)
    public ResponseEntity<Object> handleIncorrectTopicRequestException(Exception exception, WebRequest request) {
        MessageServicesException response = new MessageServicesException(exception.getMessage(),
                                                                            request.getDescription(false),
                                                                            HttpStatus.BAD_REQUEST,
                                                                            LocalDateTime.now());

        return new ResponseEntity<>(response, response.httpStatus());
    }

    @ExceptionHandler(NotFoundTopicExceptions.class)
    public ResponseEntity<Object> handleNotFoundTopicExceptions(Exception exception, WebRequest request) {
        MessageServicesException response = new MessageServicesException(exception.getMessage(),
                                                                            request.getDescription(false),
                                                                            HttpStatus.BAD_REQUEST,
                                                                            LocalDateTime.now());

        return new ResponseEntity<>(response, response.httpStatus());
    }
}
