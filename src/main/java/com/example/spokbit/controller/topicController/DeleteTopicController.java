package com.example.spokbit.controller.topicController;

import com.example.spokbit.services.topicServices.DeleteTopic;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DeleteTopicController {
    private final DeleteTopic delete;

    @Autowired
    public DeleteTopicController(DeleteTopic deleteTopic) {
        this.delete = deleteTopic;
    }

    @DeleteMapping(value = "/topics/{topicId}")
    @Operation(tags = {"getAllTopics"}, operationId = "deleteTopics", summary = "this is the summary", description = "description")
    public ResponseEntity<Void> deleteTopic(@PathVariable("topicId") Long id) {
        delete.theNextTopicBy(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
