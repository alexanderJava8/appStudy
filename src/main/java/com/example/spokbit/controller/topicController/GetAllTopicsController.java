package com.example.spokbit.controller.topicController;

import com.example.spokbit.converter.TopicConverter;
import com.example.spokbit.dto.TopicDTO;
import com.example.spokbit.entitys.Topic;
import com.example.spokbit.services.topicServices.GetTopics;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
/*esto es solo prueba, eliminarlo despues*/
@CrossOrigin(origins = {"http://localhost:5500/", "http://127.0.0.1:5500/"})
public class GetAllTopicsController {
    private final GetTopics getTopics;
    private final TopicConverter topicConverter;

    @Autowired
    public GetAllTopicsController(GetTopics getTopics, TopicConverter topicConverter) {
        this.getTopics = getTopics;
        this.topicConverter = topicConverter;
    }

    @Operation(
            summary = "Get all topics",
            description = "Retrieves a paginated list of all topics, with customizable page size and number.",
            tags = {"Topics"}
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Successfully retrieved the list of topics",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = TopicDTO.class))
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid page or size parameters"
            )
    })
    @GetMapping(value = "/topics")
    public ResponseEntity<List<TopicDTO>> getAllTopics(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "15") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        List<Topic> topics = getTopics.getAllTopics(pageable);
        List<TopicDTO> topicsDto = topicConverter.convertListTopicToListTopicDto(topics);

        return new ResponseEntity<>(topicsDto, HttpStatus.OK);
    }
}
