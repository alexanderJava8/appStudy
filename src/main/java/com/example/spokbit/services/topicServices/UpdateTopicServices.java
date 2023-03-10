package com.example.spokbit.services.topicServices;

import com.example.spokbit.entitys.Topic;
import com.example.spokbit.repository.TopicRepository;
import com.example.spokbit.validator.TopicValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UpdateTopicServices implements UpdateTopic {
    private final TopicRepository topicRepository;

    @Autowired
    public UpdateTopicServices(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    @Override
    @Transactional
    public Topic theNext(Topic topic) {
        TopicValidator.valideteThis(topic);
        Topic getTopic = topicRepository.findById(topic.getId()).orElseThrow(() -> new RuntimeException("no hay producto"));
        getTopic.setComments(topic.getComments());

        return topicRepository.save(getTopic);
    }


}
