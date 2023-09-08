package com.example.spokbit.services.commentServices;

import com.example.spokbit.entitys.Comment;
import com.example.spokbit.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentsByTopicIdServices implements CommentsByTopicId {
    private final CommentRepository commentRepository;

    @Autowired
    public CommentsByTopicIdServices(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public List<Comment> getByTopic(Long id) {
        return commentRepository.findCommentByTopicId(id);
    }
}
