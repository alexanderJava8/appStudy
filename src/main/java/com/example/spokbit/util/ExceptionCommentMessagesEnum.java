package com.example.spokbit.util;

public enum ExceptionCommentMessagesEnum {
    INCORRECT_REQUEST_NULL_COMMENT("Null Comment Not Allowed in Comment"),
    INCORRECT_REQUEST_EMPTY_COMMENT("Empty Comment not Allowed in Comment");

    private String value;

    ExceptionCommentMessagesEnum(String message) {
        this.value = message;
    }

    public String getValue() {
        return value;
    }
}
