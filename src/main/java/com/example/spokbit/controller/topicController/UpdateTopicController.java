package com.example.spokbit.controller.topicController;

import com.example.spokbit.converter.ConverterTopic;
import com.example.spokbit.dto.TopicDTO;
import com.example.spokbit.entitys.Topic;
import com.example.spokbit.services.topicServices.UpdateTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class UpdateTopicController {
    private final UpdateTopic update;
    private final ConverterTopic<Topic, TopicDTO> converterThisTopic;

    @Autowired
    public UpdateTopicController(UpdateTopic update, ConverterTopic<Topic, TopicDTO> converterThisTopic) {
        this.update = update;
        this.converterThisTopic = converterThisTopic;
    }

    @PutMapping(value = "/topics")
    public ResponseEntity<TopicDTO> updateTopic(@RequestBody TopicDTO topic) {
        Topic topicEntity = converterThisTopic.toEntity(topic);
        update.theNext(topicEntity);

        return new ResponseEntity<>(converterThisTopic.toDto(topicEntity), HttpStatus.OK);
    }
}
