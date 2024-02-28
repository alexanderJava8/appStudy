package com.example.spokbit.util;

public enum ExceptionVideoMessagesEnum {
    INCORRECT_REQUEST_NULL_URL("Null Url Not Allowed in Video"),
    INCORRECT_REQUEST_EMPTY_URL("Empty url not Allowed in video"),
    INCORRECT_REQUEST_URL_NOT_FROM_YOUTUBE("Url not from youtube"),
    VIDEO_NOT_FOUND("Video Not found");

    private final String message;

    ExceptionVideoMessagesEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
