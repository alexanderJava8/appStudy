package com.example.spokbit.services.commentServices;

import com.example.spokbit.entitys.Comment;
import com.example.spokbit.exception.exceptionComment.NotFoundCommentException;
import com.example.spokbit.repository.CommentRepository;
import com.example.spokbit.util.ExceptionCommentMessagesEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class DeleteCommentServices implements DeleteComment{
    private final CommentRepository commentRepository;

    @Autowired
    public DeleteCommentServices(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public void delete(Long id) {
        Objects.requireNonNull(id, "The id should not be null");
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new NotFoundCommentException(ExceptionCommentMessagesEnum.COMMENT_DOES_NOT_EXIST.getValue()));

        commentRepository.delete(comment);
    }
}
