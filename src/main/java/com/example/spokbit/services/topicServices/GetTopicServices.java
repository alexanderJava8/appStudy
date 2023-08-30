package com.example.spokbit.services.topicServices;

import com.example.spokbit.entitys.Topic;
import com.example.spokbit.exception.NotFoundTopicExceptions;
import com.example.spokbit.repository.TopicRepository;
import com.example.spokbit.util.ExceptionMessagesEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetTopicServices implements GetTopic {
    private final TopicRepository topicRepository;

    @Autowired
    public GetTopicServices(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    @Override
    public Topic ById(Long idOfTopic) {
        return topicRepository.findById(idOfTopic)
                .orElseThrow(() -> new NotFoundTopicExceptions(ExceptionMessagesEnum.TOPIC_DOES_NOT_EXIST.getValue()));
    }
}
