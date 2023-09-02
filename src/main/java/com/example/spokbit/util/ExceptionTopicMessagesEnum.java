package com.example.spokbit.util;

public enum ExceptionTopicMessagesEnum {
    INCORRECT_REQUEST_NULL_NAME("Null Name Not Allowed in Topics"),
    INCORRECT_REQUEST_EMPTY_NAME("Empty Name not Allowed in Topics"),
    TOPIC_DOES_NOT_EXIST("Topic Does Not Exist"),
    INCORRECT_REQUEST_NULL_ID("A null ID in the topic is not allowed");

    private final String value;

    ExceptionTopicMessagesEnum(String msg) {
        value = msg;
    }

    public String getValue() {
        return value;
    }
}
