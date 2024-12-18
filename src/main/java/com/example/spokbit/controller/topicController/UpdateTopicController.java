package com.example.spokbit.controller.topicController;

import com.example.spokbit.converter.TopicConverter;
import com.example.spokbit.dto.TopicDTO;
import com.example.spokbit.entitys.Topic;
import com.example.spokbit.services.topicServices.UpdateTopic;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(
            summary = "Update an existing topic",
            description = "Updates the details of an existing topic with the provided data.",
            tags = {"Topics"}
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Topic successfully updated",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = TopicDTO.class))
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid topic data provided"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Topic not found"
            )
    })
    @PutMapping(value = "/topics")
    public ResponseEntity<TopicDTO> updateTopic(@RequestBody TopicDTO topic) {
        Topic topicEntity = topicConverter.convertTopicDtoToTopicEntity(topic);
        update.theNext(topicEntity);

        return new ResponseEntity<>(topicConverter.convertTopicToTopicDto(topicEntity), HttpStatus.OK);
    }
}
