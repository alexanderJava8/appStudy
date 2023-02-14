package com.example.spokbit.services.topicServices;

import com.example.spokbit.entitys.Topic;
import com.example.spokbit.repository.TopicRepository;
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
    public Topic getTopicById(Long idOfTopic) {
        return topicRepository.findById(idOfTopic).orElseThrow(() -> new RuntimeException("there is not topic"));
    }
}
