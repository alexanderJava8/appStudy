package com.example.spokbit.services.topicServices;

import com.example.spokbit.entitys.Topic;
import com.example.spokbit.exception.NotFoundTopicExceptions;
import com.example.spokbit.repository.TopicRepository;
import com.example.spokbit.util.ExceptionTopicMessagesEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DeleteTopicServices implements DeleteTopic {
    private final TopicRepository topicRepository;

    @Autowired
    public DeleteTopicServices(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    @Override
    public ResponseEntity<Void> theNextTopicBy(Long id) {
        Topic topic = topicRepository.findById(id)
                .orElseThrow(() -> new NotFoundTopicExceptions(ExceptionTopicMessagesEnum.TOPIC_DOES_NOT_EXIST.getValue()));

        topicRepository.delete(topic);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
