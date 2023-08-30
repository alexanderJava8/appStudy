package com.example.spokbit.controller.topicController;

import com.example.spokbit.converter.TopicConverter;
import com.example.spokbit.dto.TopicDTO;
import com.example.spokbit.entitys.Topic;
import com.example.spokbit.services.topicServices.GetTopic;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetTopicController {
    private final GetTopic getTopic;
    private final TopicConverter topicConverter;

    @Autowired
    public GetTopicController(GetTopic getTopic, TopicConverter topicConverter) {
        this.getTopic = getTopic;
        this.topicConverter = topicConverter;
    }

    @GetMapping(value = "/topics/{topicId}")
    @Operation(tags = {"getAllTopics"}, operationId = "getTopic", summary = "this is the summary", description = "description")
    public ResponseEntity<TopicDTO> getTopic(@PathVariable("topicId") Long idOfTopic) {
        Topic topic = getTopic.ById(idOfTopic);

        return new ResponseEntity<>(topicConverter.convertTopicToTopicDto(topic), HttpStatus.OK);
    }
}
