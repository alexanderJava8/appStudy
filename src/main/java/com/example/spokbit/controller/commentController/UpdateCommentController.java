package com.example.spokbit.controller.commentController;

import com.example.spokbit.converter.CommentConverter;
import com.example.spokbit.dto.CommentDto;
import com.example.spokbit.dto.CommentToUpdate;
import com.example.spokbit.entitys.Comment;
import com.example.spokbit.services.commentServices.UpdateComment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"http://localhost:5500/", "http://127.0.0.1:5500/"})
public class UpdateCommentController {
    private final UpdateComment updateComment;
    private final CommentConverter converter;

    public UpdateCommentController(UpdateComment updateComment, CommentConverter converter) {
        this.updateComment = updateComment;
        this.converter = converter;
    }

    @PutMapping(value = "/comments")
    public ResponseEntity<CommentDto> updateComment(@RequestBody CommentToUpdate comment) {
        Comment updatedComment = updateComment.updateThis(comment);
        return new ResponseEntity<>(converter.convertCommentEntityToCommentDto(updatedComment), HttpStatus.OK);
    }
}
