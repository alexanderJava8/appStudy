package com.example.spokbit.util;

public enum ExceptionMessagesEnum {
    INCORRECT_REQUEST_EMPTY_COMMENTS("Empty Comments Not Allowed in Topics"),
    TOPIC_DOES_NOT_EXIST("The Request Topic Does Not Exist");


    ExceptionMessagesEnum(String msg) {
        value = msg;
    }

    private final String value;

    public String getValue() {
        return value;
    }
}
