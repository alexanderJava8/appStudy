package com.example.spokbit.controller.commentController;

import com.example.spokbit.dto.CommentDto;
import com.example.spokbit.entitys.Comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.example.spokbit.services.commentServices.CommentById;
import com.example.spokbit.converter.CommentConverter;


@RestController
public class GetCommentByIdController {
    private final CommentById commentById;
    private final CommentConverter commentConverter;

    public GetCommentByIdController(CommentById commentId, CommentConverter commentConverter) {
        this.commentById = commentId;
        this.commentConverter = commentConverter;
    }

    @GetMapping("/comments/{id}")
    public ResponseEntity<CommentDto> getComment(@PathVariable("id") Long id) {
        Comment comment = commentById.getComment(id);
        CommentDto commentDto = commentConverter.convertCommentEntityToCommentDto(comment);

        return new ResponseEntity<>(commentDto, HttpStatus.OK);
    }
}
