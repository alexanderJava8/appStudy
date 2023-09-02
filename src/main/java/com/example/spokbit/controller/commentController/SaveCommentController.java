package com.example.spokbit.controller.commentController;

import com.example.spokbit.converter.CommentConverter;
import com.example.spokbit.dto.CommentDto;
import com.example.spokbit.entitys.Comment;
import com.example.spokbit.services.commentServices.SaveComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaveCommentController {
    private SaveComment saveComment;
    private CommentConverter commentConverter;

    @Autowired
    public SaveCommentController(SaveComment saveComment, CommentConverter commentConverter) {
        this.saveComment = saveComment;
        this.commentConverter = commentConverter;
    }

    @PostMapping(value = "/comments")
    public ResponseEntity<CommentDto> saveComment(@RequestBody CommentDto commentDto) {
        Comment newComment = commentConverter.convertCommentDtoToCommentEntity(commentDto);
        saveComment.saveComment(newComment);

        return new ResponseEntity<>(commentConverter.convertCommentEntityToCommentDto(newComment), HttpStatus.OK);
    }
}
