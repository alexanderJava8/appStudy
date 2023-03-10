package com.example.spokbit.validator;

import com.example.spokbit.entitys.Topic;
import com.example.spokbit.exception.IncorrectTopicRequestException;
import com.example.spokbit.utils.ExceptionMessagesEnum;

public final class TopicValidator {
    public static boolean valideteThis(Topic topic) {
        if (topic.getComments() == null || topic.getComments().isEmpty()) {
            throw new IncorrectTopicRequestException(ExceptionMessagesEnum.INCORRECT_REQUEST_EMPTY_COMMENTS.getValue());
        }
        return true;
    }
}
