package com.example.spokbit.controller.commentController;

import com.example.spokbit.repository.CommentRepository;
import com.example.spokbit.services.commentServices.DeleteComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteCommentController {
    private final CommentRepository commentRepository;
    private final DeleteComment deleteComment;

    @Autowired
    public DeleteCommentController(CommentRepository commentRepository, DeleteComment deleteComment) {
        this.commentRepository = commentRepository;
        this.deleteComment = deleteComment;
    }

    @DeleteMapping(value = "comments/{long_Id_Topic_Comments}")
    public ResponseEntity<Void> deleteComment(@PathVariable("long_Id_Topic_Comments") Long id) {
        deleteComment.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
