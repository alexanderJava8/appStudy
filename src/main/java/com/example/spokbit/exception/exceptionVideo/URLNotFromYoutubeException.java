package com.example.spokbit.exception.exceptionVideo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class URLNotFromYoutubeException extends RuntimeException {
    public URLNotFromYoutubeException(String message) {
        super(message);
    }
}
