package com.example.spokbit.handler;

import com.example.spokbit.exception.MessageServicesException;
import com.example.spokbit.exception.exceptionVideo.IncorrectVideoRequestException;
import com.example.spokbit.exception.exceptionVideo.URLNotFromYoutube;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
@RestController
public class VideoServiceExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object>  handleAllExceptions(Exception e, WebRequest request) {
        MessageServicesException response = new MessageServicesException(
                e.getMessage(),
                request.getDescription(false),
                HttpStatus.BAD_REQUEST,
                LocalDateTime.now()
        );

        return new ResponseEntity<>(response, response.httpStatus());
    }

    @ExceptionHandler(IncorrectVideoRequestException.class)
    public ResponseEntity<Object> handleIncorrectVideoRequestException(IncorrectVideoRequestException e, WebRequest request) {
        MessageServicesException response = new MessageServicesException(
                e.getMessage(),
                request.getDescription(false),
                HttpStatus.BAD_REQUEST,
                LocalDateTime.now()
        );

        return new ResponseEntity<>(response, response.httpStatus());
    }

    @ExceptionHandler(URLNotFromYoutube.class)
    public ResponseEntity<Object> handleUrlNotFromYoutube(URLNotFromYoutube e, WebRequest request) {
        MessageServicesException response = new MessageServicesException(
                e.getMessage(),
                request.getDescription(false),
                HttpStatus.BAD_REQUEST,
                LocalDateTime.now()
        );

        return new ResponseEntity<>(response, response.httpStatus());
    }
}
