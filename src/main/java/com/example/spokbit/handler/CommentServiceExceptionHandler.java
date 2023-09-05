package com.example.spokbit.handler;

import com.example.spokbit.exception.MessageServicesException;
import com.example.spokbit.exception.exceptionComment.IncorrectCommentRequestException;
import com.example.spokbit.exception.exceptionTopic.NotFoundTopicExceptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice(basePackages = "com.example.spokbit.controller.commentController")
@RestController
public class CommentServiceExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAllExceptions(Exception e, WebRequest request) {
        MessageServicesException response = new MessageServicesException(
                                            e.getMessage(),
                                            request.getDescription(false),
                                            HttpStatus.INTERNAL_SERVER_ERROR,
                                            LocalDateTime.now()
                                    );

        return new ResponseEntity<>(response, response.httpStatus());
    }

    @ExceptionHandler(IncorrectCommentRequestException.class)
    public ResponseEntity<Object> handleIncorrectCommentRequestException(Exception e, WebRequest request) {
        MessageServicesException response = new MessageServicesException(
                e.getMessage(),
                request.getDescription(false),
                HttpStatus.BAD_REQUEST,
                LocalDateTime.now()
        );

        return new ResponseEntity<>(response, response.httpStatus());
    }

    @ExceptionHandler(NotFoundTopicExceptions.class)
    public ResponseEntity<Object> handleTopicDoesNotExist(NotFoundTopicExceptions e, WebRequest request) {
        MessageServicesException response = new MessageServicesException(
                e.getMessage(),
                request.getDescription(false),
                HttpStatus.BAD_REQUEST,
                LocalDateTime.now()
        );

        return new ResponseEntity<>(response, response.httpStatus());
    }
}
