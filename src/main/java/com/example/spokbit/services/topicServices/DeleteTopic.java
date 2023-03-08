package com.example.spokbit.services.topicServices;

import org.springframework.http.ResponseEntity;

public interface DeleteTopic {
    ResponseEntity<Void> theNextTopicBy(Long id);
}
