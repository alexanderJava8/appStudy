package com.example.spokbit.controller.commentController;

import com.example.spokbit.dto.CommentDto;
import com.example.spokbit.entitys.Comment;
import com.example.spokbit.services.commentServices.CommentsByTopicId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetAllCommentByTopicController {
    private final CommentsByTopicId CommentsByTopicId;

    @Autowired
    public GetAllCommentByTopicController(CommentsByTopicId commentsByTopicId) {
        CommentsByTopicId = commentsByTopicId;
    }

    @GetMapping(value = "/comments/topicID/{topicId}")
    public ResponseEntity<List<Comment>> commentsByTopicId(@PathVariable("topicId") Long id) {
        List<Comment> comments = CommentsByTopicId.getByTopic(id);
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }
}
