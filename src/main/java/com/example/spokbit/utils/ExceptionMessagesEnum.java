package com.example.spokbit.utils;

public enum ExceptionMessagesEnum {
    INCORRECT_REQUEST_EMPTY_COMMENTS("Empty Comments Not Allowed in Topics");

    ExceptionMessagesEnum(String msg) {
        value = msg;
    }

    private final String value;

    public String getValue() {
        return value;
    }
}
