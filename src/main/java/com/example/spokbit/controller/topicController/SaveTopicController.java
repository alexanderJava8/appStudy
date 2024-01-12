package com.example.spokbit.controller.topicController;

import com.example.spokbit.converter.TopicConverter;
import com.example.spokbit.dto.TopicDTO;
import com.example.spokbit.entitys.Topic;
import com.example.spokbit.services.topicServices.SaveTopic;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
/* esto es solo prueba, eliminarlo despues */
@CrossOrigin(origins = {"http://localhost:5500/", "http://127.0.0.1:5500/"})
public class SaveTopicController {
    private final SaveTopic topic;
    private final TopicConverter topicConverter;

    @Autowired
    public SaveTopicController(SaveTopic topic, TopicConverter topicConverter) {
        this.topic = topic;
        this.topicConverter = topicConverter;
    }

    @PostMapping(value = "/topics")
    @Operation(tags = {
            "getAllTopics" }, operationId = "saveTopics", summary = "this is the summary", description = "description")
    public ResponseEntity<TopicDTO> saveTopic(@RequestBody TopicDTO topicDto) {
        Topic topicSave = topic.save(topicConverter.convertTopicDtoToTopicEntity(topicDto));

        TopicDTO topicDTO = topicConverter.convertTopicToTopicDto(topicSave);
        return new ResponseEntity<>(topicDTO, HttpStatus.CREATED);
    }
}
