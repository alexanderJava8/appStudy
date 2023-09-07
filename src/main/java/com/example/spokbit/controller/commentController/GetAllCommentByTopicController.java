package com.example.spokbit.controller.commentController;

import com.example.spokbit.dto.CommentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetAllCommentByTopicController {
    private final CommentByTopicId CommentByTopicId;

    @Autowired
    public GetAllCommentByTopicController(CommentByTopicId CommentByTopicId) {
        this.CommentByTopicId = CommentByTopicId;
    }

    @GetMapping(value = "/comments")
    public ResponseEntity<List<CommentDto>> commentsByTopicId(Long id) {
        List<CommentDto> comments = CommentByTopicId.get(id);
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }
}
