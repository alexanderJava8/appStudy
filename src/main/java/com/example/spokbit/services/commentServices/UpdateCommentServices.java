package com.example.spokbit.services.commentServices;

import com.example.spokbit.dto.CommentToUpdate;
import com.example.spokbit.entitys.Comment;
import com.example.spokbit.exception.exceptionComment.IncorrectCommentToUpdateException;
import com.example.spokbit.exception.exceptionComment.NotFoundCommentException;
import com.example.spokbit.repository.CommentRepository;
import com.example.spokbit.util.ExceptionCommentMessagesEnum;
import com.example.spokbit.validator.CommentToUpdateValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class UpdateCommentServices implements UpdateComment {
    private final CommentRepository commentRepository;

    public UpdateCommentServices(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public Comment updateThis(CommentToUpdate comment) {
        CommentToUpdateValidator.validateThis(comment);
        Comment commentUpdate = existComment(comment);
        log.info("valor del objeto:{}", commentUpdate);

        commentUpdate.setComment(comment.newComment());
        log.info("valor del objeto:{}", commentUpdate);

        return commentRepository.save(commentUpdate);
    }

    private Comment existComment(CommentToUpdate comment) {
         return commentRepository
                 .findById(comment.id())
                 .orElseThrow(() -> new NotFoundCommentException(ExceptionCommentMessagesEnum.COMMENT_DOES_NOT_EXIST.getValue()));
    }
}
