package com.example.spokbit.util;

public enum ExceptionCommentMessagesEnum {
    INCORRECT_REQUEST_NULL_COMMENT("Null Comment Not Allowed in Comment"),
    INCORRECT_REQUEST_EMPTY_COMMENT("Empty Comment Not Allowed in Comment"),
    COMMENT_DOES_NOT_EXIST("Comment Does Not Exist");

    private String value;

    ExceptionCommentMessagesEnum(String message) {
        this.value = message;
    }

    public String getValue() {
        return value;
    }
}
