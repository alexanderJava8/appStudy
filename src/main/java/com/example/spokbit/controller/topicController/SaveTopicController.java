package com.example.spokbit.controller.topicController;

import com.example.spokbit.converter.ConverterTopic;
import com.example.spokbit.dto.TopicDTO;
import com.example.spokbit.entitys.Topic;
import com.example.spokbit.services.topicServices.SaveTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaveTopicController {
    private final SaveTopic topic;
    private final ConverterTopic<Topic, TopicDTO> converterThisTopic;

    @Autowired
    public SaveTopicController(SaveTopic topic, ConverterTopic<Topic, TopicDTO> converterTopic) {
        this.topic = topic;
        this.converterThisTopic = converterTopic;
    }

    @PostMapping(value = "/topics")
    public ResponseEntity<TopicDTO> saveTopic(@RequestBody TopicDTO topicDTO) {
        Topic topicEntity = converterThisTopic.toEntity(topicDTO);
        topic.save(topicEntity);

        return new ResponseEntity<>(converterThisTopic.toDto(topicEntity), HttpStatus.CREATED);
    }
}
