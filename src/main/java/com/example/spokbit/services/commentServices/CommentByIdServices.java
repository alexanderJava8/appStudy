package com.example.spokbit.services.commentServices;

import java.util.Optional;

import org.springframework.stereotype.Service;
import com.example.spokbit.entitys.Comment;
import com.example.spokbit.exception.exceptionComment.NotFoundCommentException;
import com.example.spokbit.repository.CommentRepository;
import com.example.spokbit.util.ExceptionCommentMessagesEnum;

@Service
public class CommentByIdServices implements CommentById {
    private final CommentRepository commentRepository;

    public CommentByIdServices(CommentRepository commentRepo) {
        this.commentRepository = commentRepo;
    }

    public Comment getComment(Long id) {
        return commentRepository.findById(id)
                                .orElseThrow(() ->  new NotFoundCommentException(ExceptionCommentMessagesEnum.COMMENT_DOES_NOT_EXIST.getValue()));
    }
} 