package com.example.spokbit.validator;

import com.example.spokbit.entitys.Topic;
import com.example.spokbit.exception.IncorrectTopicRequestException;
import com.example.spokbit.util.ExceptionTopicMessagesEnum;

import java.util.Objects;

public final class TopicValidator {
    public static boolean valideteThis(Topic topic) {
        if (Objects.equals(topic.getName(), null)) {
            throw new IncorrectTopicRequestException(ExceptionTopicMessagesEnum.INCORRECT_REQUEST_NULL_NAME.getValue());
        }

        if (Objects.equals(topic.getName(), "")) {
            throw new IncorrectTopicRequestException(ExceptionTopicMessagesEnum.INCORRECT_REQUEST_EMPTY_NAME.getValue());
        }

        return true;
    }
}
