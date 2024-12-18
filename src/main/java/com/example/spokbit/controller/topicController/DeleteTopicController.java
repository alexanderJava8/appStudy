package com.example.spokbit.controller.topicController;

import com.example.spokbit.services.topicServices.DeleteTopic;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = {"http://localhost:5500/", "http://127.0.0.1:5500/"})
public class DeleteTopicController {
    private final DeleteTopic delete;

    @Autowired
    public DeleteTopicController(DeleteTopic deleteTopic) {
        this.delete = deleteTopic;
    }

    @Operation(
            summary = "Delete a topic",
            description = "Deletes a specific topic identified by the given topic ID.",
            tags = {"Topics"}
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Successfully deleted the topic"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Topic not found"
            )
    })
    @DeleteMapping(value = "/topics/{topicId}")
    public ResponseEntity<Void> deleteTopic(@PathVariable("topicId") Long id) {
        delete.theNextTopicBy(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
