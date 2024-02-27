package com.example.spokbit.exception.exceptionVideo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class URLNotFromYoutube extends RuntimeException {
    public URLNotFromYoutube(String message) {
        super(message);
    }
}
