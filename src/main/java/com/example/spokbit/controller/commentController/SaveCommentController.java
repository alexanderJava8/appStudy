package com.example.spokbit.controller.commentController;

import com.example.spokbit.converter.CommentConverter;
import com.example.spokbit.dto.CommentDto;
import com.example.spokbit.entitys.Comment;
import com.example.spokbit.services.commentServices.SaveComment;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
/*esto es solo prueba, eliminarlo despues*/
@CrossOrigin(origins = {"http://localhost:5500/", "http://127.0.0.1:5500/"})
public class SaveCommentController {
    private SaveComment saveComment;
    private CommentConverter commentConverter;

    public SaveCommentController(SaveComment saveComment, CommentConverter commentConverter) {
        this.saveComment = saveComment;
        this.commentConverter = commentConverter;
    }

    @Operation(
            summary = "Save a new comment",
            description = "Creates a new comment based on the provided CommentDto and saves it to the database.",
            tags = {"Comments"}
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Successfully created a new comment",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = CommentDto.class))
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid input provided for the comment"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "An error occurred while saving the comment"
            )
    })
    @PostMapping(value = "/comments")
    public ResponseEntity<CommentDto> saveComment(@RequestBody CommentDto commentDto) {
        Comment newComment = commentConverter.convertCommentDtoToCommentEntity(commentDto);
        Comment comment = saveComment.saveComment(newComment);

        return new ResponseEntity<>(commentConverter.convertCommentEntityToCommentDto(comment), HttpStatus.CREATED);
    }
}
