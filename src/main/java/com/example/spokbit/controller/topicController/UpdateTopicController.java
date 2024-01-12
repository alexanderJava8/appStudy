package com.example.spokbit.controller.topicController;

import com.example.spokbit.converter.TopicConverter;
import com.example.spokbit.dto.TopicDTO;
import com.example.spokbit.entitys.Topic;
import com.example.spokbit.services.topicServices.UpdateTopic;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
/*esto es solo prueba, eliminarlo despues*/
@CrossOrigin(origins = {"http://localhost:5500", "http://127.0.0.1:5500/"})
public final class UpdateTopicController {
    private final UpdateTopic update;
    private final TopicConverter topicConverter;

    @Autowired
    public UpdateTopicController(UpdateTopic update, TopicConverter topicConverter) {
        this.update = update;
        this.topicConverter = topicConverter;
    }

    @PutMapping(value = "/topics")
    @Operation(tags = {"getAllTopics"}, operationId = "updateTopics", summary = "this is the summary", description = "description")
    public ResponseEntity<TopicDTO> updateTopic(@RequestBody TopicDTO topic) {
        Topic topicEntity = topicConverter.convertTopicDtoToTopicEntity(topic);
        update.theNext(topicEntity);

        return new ResponseEntity<>(topicConverter.convertTopicToTopicDto(topicEntity), HttpStatus.OK);
    }
}
