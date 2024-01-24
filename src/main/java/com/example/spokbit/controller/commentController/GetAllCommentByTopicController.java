package com.example.spokbit.controller.commentController;

import com.example.spokbit.converter.CommentConverter;
import com.example.spokbit.dto.CommentDto;
import com.example.spokbit.entitys.Comment;
import com.example.spokbit.services.commentServices.CommentsByTopicId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
/*esto es solo prueba, eliminarlo despues*/
@CrossOrigin(origins = {"http://localhost:5500/", "http://127.0.0.1:5500/"})
public class GetAllCommentByTopicController {
    private final CommentsByTopicId CommentsByTopicId;
    private final CommentConverter commentConverter;

    public GetAllCommentByTopicController(CommentsByTopicId commentsByTopicId, CommentConverter commentConverter) {
        CommentsByTopicId = commentsByTopicId;
        this.commentConverter = commentConverter;
    }

    @GetMapping(value = "/comments/topicID/{topicId}")
    public ResponseEntity<List<CommentDto>> commentsByTopicId(@PathVariable("topicId") Long id) {
        List<Comment> comments = CommentsByTopicId.getByTopic(id);
        List<CommentDto> commentDtos = commentConverter.convertCommentEntityToCommentDto(comments);
        return new ResponseEntity<>(commentDtos, HttpStatus.OK);
    }
}
