package com.example.spokbit.handler;

import com.example.spokbit.exception.MessageServicesException;
import com.example.spokbit.exception.exceptionVideo.IncorrectVideoRequestException;
import com.example.spokbit.exception.exceptionVideo.URLNotFromYoutubeException;
import com.example.spokbit.exception.exceptionVideo.VideoNotFoundException;
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

    @ExceptionHandler(URLNotFromYoutubeException.class)
    public ResponseEntity<Object> handleUrlNotFromYoutube(URLNotFromYoutubeException e, WebRequest request) {
        MessageServicesException response = new MessageServicesException(
                e.getMessage(),
                request.getDescription(false),
                HttpStatus.BAD_REQUEST,
                LocalDateTime.now()
        );

        return new ResponseEntity<>(response, response.httpStatus());
    }

    @ExceptionHandler(VideoNotFoundException.class)
    public ResponseEntity<Object> handleVideoNotFound(VideoNotFoundException e, WebRequest request) {
        MessageServicesException response = new MessageServicesException(
                e.getMessage(),
                request.getDescription(false),
                HttpStatus.NOT_FOUND,
                LocalDateTime.now()
        );

        return new ResponseEntity<>(response, response.httpStatus());
    }
}
