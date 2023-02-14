package com.example.spokbit.controller.topicController;

import com.example.spokbit.entitys.Topic;
import com.example.spokbit.services.topicServices.GetTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class getTopicController {
    private final GetTopic getTopic;

    @Autowired
    public getTopicController(GetTopic getTopic) {
        this.getTopic = getTopic;
    }

    @GetMapping(value = "/topics/{topicId}")
    public ResponseEntity<Topic> getTopic(@PathVariable("topicId") Long idOfTopic) {
        Topic topic = getTopic.getTopicById(idOfTopic);
        return new ResponseEntity<>(topic, HttpStatus.OK);
    }
}
