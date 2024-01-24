package com.example.spokbit.util;

public enum ExceptionCommentUpdateMessagesException {
    INCORRECT_REQUEST_ID_NULL_COMMENT_UPDATE("Null Id Not Allowed In Comment Update"),
    INCORRECT_REQUEST_ID_EMPTY_COMMENT_UPDATE("ID"),
    INCORRECT_REQUEST_NULL_COMMENT_UPDATE("Null Comment Not Allowed in Comment Update");

    private String message;

    ExceptionCommentUpdateMessagesException(String message) {
        this.message = message;
    }

    public String getValue() {
        return message;
    }
}
