package com.example.spokbit.services.topicServices;

import com.example.spokbit.entitys.Topic;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface GetTopics {
    List<Topic> getAllTopics(Pageable pageable);
}
