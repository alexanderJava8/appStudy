package com.example.spokbit.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
public final class TopicServiceExceptionResponse {
    private String message;
    private String details;
    private HttpStatus status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;

    public TopicServiceExceptionResponse(String message, String details, HttpStatus status, LocalDateTime timestamp) {
        this.message = message;
        this.details = details;
        this.status = status;
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TopicServiceExceptionResponse that = (TopicServiceExceptionResponse) o;
        return Objects.equals(message, that.message) && Objects.equals(details, that.details) && status == that.status && Objects.equals(timestamp, that.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message, details, status, timestamp);
    }

    @Override
    public String toString() {
        return "TopicServiceExceptionResponse{" +
                "message='" + message + '\'' +
                ", details='" + details + '\'' +
                ", status=" + status +
                ", timestamp=" + timestamp +
                '}';
    }
}
