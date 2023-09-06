package com.example.spokbit.services.commentServices;

import com.example.spokbit.entitys.Comment;
import com.example.spokbit.exception.exceptionComment.NotFoundCommentException;
import com.example.spokbit.repository.CommentRepository;
import com.example.spokbit.util.ExceptionCommentMessagesEnum;
import com.example.spokbit.validator.CommentValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateCommentServices implements UpdateComment {
    private final CommentRepository commentRepository;

    @Autowired
    public UpdateCommentServices(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public Comment updateThis(Comment comment) {
        Comment commentUpdate = existComment(comment);
        CommentValidator.valideteThis(comment);

        commentUpdate.setComment(comment.getComment());
        return commentRepository.save(commentUpdate);
    }

    private Comment existComment(Comment comment) {
         return commentRepository
                 .findById(comment.getId())
                 .orElseThrow(() -> new NotFoundCommentException(ExceptionCommentMessagesEnum.COMMENT_DOES_NOT_EXIST.getValue()));
    }
}
