package com.example.spokbit.services.commentServices;

import com.example.spokbit.entitys.Comment;
import com.example.spokbit.entitys.Topic;
import com.example.spokbit.exception.exceptionTopic.NotFoundTopicExceptions;
import com.example.spokbit.repository.CommentRepository;
import com.example.spokbit.repository.TopicRepository;
import com.example.spokbit.util.ExceptionTopicMessagesEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentsByTopicIdServices implements CommentsByTopicId {
    private final CommentRepository commentRepository;
    private final TopicRepository topicRepository;

    @Autowired
    public CommentsByTopicIdServices(CommentRepository commentRepository, TopicRepository topicRepository) {
        this.commentRepository = commentRepository;
        this.topicRepository = topicRepository;
    }

    @Override
    public List<Comment> getByTopic(Long id) {
        existTopic(id);
        return commentRepository.findCommentsByTopicId(id);
    }

    private void existTopic(Long id) {
        Optional<Topic> topic = topicRepository.findById(id);

        if (topic.isEmpty()) {
            throw new NotFoundTopicExceptions(ExceptionTopicMessagesEnum.TOPIC_DOES_NOT_EXIST.getValue());
        }
    }
}
