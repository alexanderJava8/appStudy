package com.example.spokbit.services.topicServices;

import com.example.spokbit.entitys.Topic;
import com.example.spokbit.exception.NotFoundTopicExceptions;
import com.example.spokbit.repository.TopicRepository;
import com.example.spokbit.util.ExceptionTopicMessagesEnum;
import com.example.spokbit.validator.TopicValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UpdateTopicServices implements UpdateTopic {
    private final TopicRepository topicRepository;

    @Autowired
    public UpdateTopicServices(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public Topic theNext(Topic topic) {
        TopicValidator.valideteThis(topic);
        Topic getTopic = topicRepository.findById(topic.getId())
                .orElseThrow(() -> new NotFoundTopicExceptions(ExceptionTopicMessagesEnum.TOPIC_DOES_NOT_EXIST.getValue()));

        getTopic.setName(topic.getName());
        return topicRepository.save(getTopic);
    }
}
