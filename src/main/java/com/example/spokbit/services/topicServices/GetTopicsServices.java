package com.example.spokbit.services.topicServices;


import com.example.spokbit.entitys.Topic;
import com.example.spokbit.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetTopicsServices implements GetTopics {
    private final TopicRepository topicRepository;

    @Autowired
    public GetTopicsServices(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    @Override
    public List<Topic> getAllTopics(Pageable pageable) {
        return topicRepository.findAll(pageable).toList();
    }
}
