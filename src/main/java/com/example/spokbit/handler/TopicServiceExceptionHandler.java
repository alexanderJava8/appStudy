package com.example.spokbit.handler;

import com.example.spokbit.exception.NotFoundTopicExceptions;
import com.example.spokbit.exception.TopicServiceExceptionResponse;
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
        TopicServiceExceptionResponse response = new TopicServiceExceptionResponse(exception.getMessage(), request.getDescription(false), HttpStatus.INTERNAL_SERVER_ERROR, LocalDateTime.now());
        return new ResponseEntity<>(response, response.getStatus());
    }

    @ExceptionHandler(NotFoundTopicExceptions.class)
    public ResponseEntity<Object> handleNotFoundTopicExceptions(Exception exception, WebRequest request) {
        TopicServiceExceptionResponse response = new TopicServiceExceptionResponse(exception.getMessage(), request.getDescription(false), HttpStatus.NO_CONTENT, LocalDateTime.now());
        return new ResponseEntity<>(response, response.getStatus());
    }
}
