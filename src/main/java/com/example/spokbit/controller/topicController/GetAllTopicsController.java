package com.example.spokbit.controller.topicController;

import com.example.spokbit.converter.TopicConverter;
import com.example.spokbit.dto.TopicDTO;
import com.example.spokbit.entitys.Topic;
import com.example.spokbit.services.topicServices.GetTopics;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetAllTopicsController {
    private final GetTopics getTopics;
    private final TopicConverter topicConverter;

    @Autowired
    public GetAllTopicsController(GetTopics getTopics, TopicConverter topicConverter) {
        this.getTopics = getTopics;
        this.topicConverter = topicConverter;
    }

    @GetMapping(value = "/topics")
    @Operation(tags = {"getAllTopics"}, operationId = "getTopics", summary = "this is the summary", description = "description")
    public ResponseEntity<List<TopicDTO>> getAllTopics(@RequestParam(name = "page", defaultValue = "0") int page,
                                                       @RequestParam(name = "size", defaultValue = "3") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        List<Topic> topics = getTopics.getAllTopics(pageable);
        List<TopicDTO> topicsDto = topicConverter.convertListTopicToListTopicDto(topics);

        return new ResponseEntity<>(topicsDto, HttpStatus.OK);
    }
}
