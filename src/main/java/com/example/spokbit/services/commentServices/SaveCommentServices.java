package com.example.spokbit.services.commentServices;

import com.example.spokbit.entitys.Comment;
import com.example.spokbit.entitys.Topic;
import com.example.spokbit.exception.exceptionTopic.NotFoundTopicExceptions;
import com.example.spokbit.repository.CommentRepository;
import com.example.spokbit.repository.TopicRepository;
import com.example.spokbit.util.ExceptionTopicMessagesEnum;
import com.example.spokbit.validator.CommentValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class SaveCommentServices implements SaveComment {
    private final CommentRepository commentRepository;
    private final TopicRepository topicRepository;

    @Autowired
    public SaveCommentServices(CommentRepository commentRepository, TopicRepository topicRepository) {
        this.commentRepository = commentRepository;
        this.topicRepository = topicRepository;
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public Comment saveComment(Comment comment) {
        existTopic(comment);
        CommentValidator.valideteThis(comment);

        return commentRepository.save(comment);
    }

    private void existTopic(Comment comment) {
        Optional<Topic> existTopic = topicRepository.findById(comment.getTopic().getId());
        if (existTopic.isEmpty()) {
            throw new NotFoundTopicExceptions(ExceptionTopicMessagesEnum.TOPIC_DOES_NOT_EXIST.getValue());
        }
    }
}
