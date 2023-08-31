package com.example.spokbit.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public record MessageServicesException(String message,
                                       String details,
                                       HttpStatus httpStatus,
                                       @JsonFormat(shape = JsonFormat.Shape.STRING,
                                       pattern = "dd-MM-yyyy hh:mm:ss")
                                       LocalDateTime timestamp) {
}
