package com.example.spokbit.services.topicServices;

import com.example.spokbit.entitys.Topic;
import com.example.spokbit.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SaveATopicServices implements SaveTopic {
    private final TopicRepository topicRepository;

    @Autowired
    public SaveATopicServices(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    @Override
    @Transactional
    public Topic save(Topic topic) {
       // TopicValidator.valideteThis(topic);
        return topicRepository.save(topic);
    }
}
