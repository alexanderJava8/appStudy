package com.example.spokbit.validator;

import com.example.spokbit.entitys.Comment;
import com.example.spokbit.exception.exceptionComment.IncorrectCommentRequestException;
import com.example.spokbit.exception.exceptionTopic.IncorrectTopicRequestException;
import com.example.spokbit.util.ExceptionCommentMessagesEnum;
import com.example.spokbit.util.ExceptionTopicMessagesEnum;

import java.util.Objects;

public final class CommentValidator {
    public static boolean valideteThis(Comment comment) {
        if (Objects.equals(comment.getTopic().getId(), null)) {
            throw new IncorrectTopicRequestException(ExceptionTopicMessagesEnum.INCORRECT_REQUEST_NULL_ID.getValue());
        }

        if (Objects.equals(comment.getComment(), "")) {
            throw new IncorrectCommentRequestException(ExceptionCommentMessagesEnum.INCORRECT_REQUEST_EMPTY_COMMENT.getValue());
        }

        if (Objects.equals(comment.getComment(), null)) {
            throw new IncorrectCommentRequestException(ExceptionCommentMessagesEnum.INCORRECT_REQUEST_NULL_COMMENT.getValue());
        }

        return true;
    }
}
