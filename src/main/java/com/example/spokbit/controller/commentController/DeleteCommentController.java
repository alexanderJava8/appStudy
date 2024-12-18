package com.example.spokbit.controller.commentController;

import com.example.spokbit.services.commentServices.DeleteComment;
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
/*esto es solo prueba, eliminarlo despues*/
@CrossOrigin(origins = {"http://localhost:5500/", "http://127.0.0.1:5500/"})
public class DeleteCommentController {
    private final DeleteComment deleteComment;

    @Autowired
    public DeleteCommentController(DeleteComment deleteComment) {
        this.deleteComment = deleteComment;
    }


    @DeleteMapping(value = "comments/{long_Id_Topic_Comments}")
    @Operation(
            summary = "Delete a comment by ID",
            description = "Deletes a comment associated with the specified ID of the topic's comments.",
            tags = {"Comments"}
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Comment deleted successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid comment ID supplied"),
            @ApiResponse(responseCode = "404", description = "Comment not found")
    })
    public ResponseEntity<Void> deleteComment(@PathVariable("long_Id_Topic_Comments") Long id) {
        deleteComment.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
