package com.example.spokbit.util;

public enum ExceptionMessagesEnum {
    INCORRECT_REQUEST_NULL_NAME("Null Name Not Allowed in Topics"),
    INCORRECT_REQUEST_EMPTY_NAME("Empty Name not Allowed in Topics"),
    TOPIC_DOES_NOT_EXIST("Topic Does Not Exist");

    private final String value;

    ExceptionMessagesEnum(String msg) {
        value = msg;
    }

    public String getValue() {
        return value;
    }
}
