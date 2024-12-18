package com.example.spokbit.controller.commentController;

import com.example.spokbit.converter.CommentConverter;
import com.example.spokbit.dto.CommentDto;
import com.example.spokbit.entitys.Comment;
import com.example.spokbit.services.commentServices.CommentsByTopicId;
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

import java.util.List;

@RestController
/*esto es solo prueba, eliminarlo despues*/
@CrossOrigin(origins = {"http://localhost:5500/", "http://127.0.0.1:5500/"})
public class GetAllCommentByTopicController {
    private final CommentsByTopicId commentsByTopicId;
    private final CommentConverter commentConverter;

    public GetAllCommentByTopicController(CommentsByTopicId commentsByTopicId, CommentConverter commentConverter) {
        this.commentsByTopicId = commentsByTopicId;
        this.commentConverter = commentConverter;
    }

    @GetMapping(value = "/comments/topicID/{topicId}")
    @Operation(
            summary = "Get comments by topic ID",
            description = "Retrieves a list of comments associated with a specific topic ID.",
            tags = {"Comments"}
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Successfully retrieved comments",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = CommentDto.class))
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid topic ID supplied"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "No comments found for the specified topic ID"
            )
    })
    public ResponseEntity<List<CommentDto>> commentsByTopicId(@PathVariable("topicId") Long id) {
        List<Comment> comments = commentsByTopicId.getByTopic(id);
        List<CommentDto> commentDtos = commentConverter.convertCommentEntityToCommentDto(comments);
        return new ResponseEntity<>(commentDtos, HttpStatus.OK);
    }
}
