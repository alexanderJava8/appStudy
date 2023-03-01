package com.example.spokbit.controller.topicController;

import com.example.spokbit.converter.ConverterTopic;
import com.example.spokbit.dto.TopicDTO;
import com.example.spokbit.entitys.Topic;
import com.example.spokbit.services.topicServices.GetTopics;
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
    private final ConverterTopic<Topic, TopicDTO>  converterThisTopic;

    public GetAllTopicsController(GetTopics getTopics, ConverterTopic<Topic, TopicDTO> converterThisTopic) {
        this.getTopics = getTopics;
        this.converterThisTopic = converterThisTopic;
    }

    @GetMapping(value = "/topics")
    public ResponseEntity<List<TopicDTO>> getAllTopics(
        @RequestParam(name = "page", defaultValue = "0") int page,
        @RequestParam(name = "size", defaultValue = "3") int size
    ) {

        Pageable pageable = PageRequest.of(page, size);
        List<Topic> topics = getTopics.getAllTopics(pageable);
        return new ResponseEntity<>(converterThisTopic.toDto(topics), HttpStatus.OK);
    }
}
