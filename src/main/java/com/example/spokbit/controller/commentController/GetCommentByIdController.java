package com.example.spokbit.controller.commentController;

import com.example.spokbit.dto.CommentDto;
import com.example.spokbit.entitys.Comment;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.example.spokbit.services.commentServices.CommentById;
import com.example.spokbit.converter.CommentConverter;


@RestController
@CrossOrigin(origins = {"http://localhost:5500/", "http://127.0.0.1:5500/"})
public class GetCommentByIdController {
    private final CommentById commentById;
    private final CommentConverter commentConverter;

    public GetCommentByIdController(CommentById commentId, CommentConverter commentConverter) {
        this.commentById = commentId;
        this.commentConverter = commentConverter;
    }

    @Operation(
            summary = "Get a comment by ID",
            description = "Retrieves a specific comment based on the provided comment ID.",
            tags = {"Comments"}
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Successfully retrieved the comment",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = CommentDto.class))
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid comment ID supplied"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Comment not found for the specified ID"
            )
    })
    @GetMapping("/comments/{id}")
    public ResponseEntity<CommentDto> getComment(@PathVariable("id") Long id) {
        Comment comment = commentById.getComment(id);
        CommentDto commentDto = commentConverter.convertCommentEntityToCommentDto(comment);

        return new ResponseEntity<>(commentDto, HttpStatus.OK);
    }
}
