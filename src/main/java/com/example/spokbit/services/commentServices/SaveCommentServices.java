package com.example.spokbit.services.commentServices;

import com.example.spokbit.entitys.Comment;
import com.example.spokbit.repository.CommentRepository;
import com.example.spokbit.validator.CommentValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SaveCommentServices implements SaveComment{
    private CommentRepository commentRepository;

    @Autowired
    public SaveCommentServices(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public Comment saveComment(Comment comment) {
        CommentValidator.valideteThis(comment);

        return commentRepository.save(comment);
    }
}
