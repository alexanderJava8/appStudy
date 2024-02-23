package com.example.spokbit.validator;

import java.util.Objects;

import com.example.spokbit.dto.CommentToUpdate;
import com.example.spokbit.exception.exceptionComment.IncorrectCommentToUpdateException;
import com.example.spokbit.util.ExceptionCommentUpdateMessagesException;

public final class CommentToUpdateValidator {
    public static boolean validateThis(CommentToUpdate comment) {
        if (Objects.equals(comment.id(), null)) {
            throw new IncorrectCommentToUpdateException(ExceptionCommentUpdateMessagesException.INCORRECT_REQUEST_ID_NULL_COMMENT_UPDATE.getValue());
        }

        if (Objects.equals(comment.id(), "")) {
            throw new IncorrectCommentToUpdateException(ExceptionCommentUpdateMessagesException.INCORRECT_REQUEST_ID_EMPTY_COMMENT_UPDATE.getValue());
        }

        if (Objects.equals(comment.newComment(), null)) {
            throw new IncorrectCommentToUpdateException(ExceptionCommentUpdateMessagesException.INCORRECT_REQUEST_NULL_COMMENT_UPDATE.getValue());
        }

        return true;
    }
}
