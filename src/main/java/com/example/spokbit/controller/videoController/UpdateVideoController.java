package com.example.spokbit.controller.videoController;

import com.example.spokbit.converter.VideoConverter;
import com.example.spokbit.dto.VideoDto;
import com.example.spokbit.entitys.Video;
import com.example.spokbit.services.videoServices.UpdateVideo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = {"http://localhost:5500/", "http://127.0.0.1:5500/"})
public class UpdateVideoController {
    private final UpdateVideo updateThisVideo;
    private final VideoConverter videoConverter;

    public UpdateVideoController(UpdateVideo updateThisVideo, VideoConverter videoConverter) {
        this.updateThisVideo = updateThisVideo;
        this.videoConverter = videoConverter;
    }

    @Operation(
            summary = "Update an existing video",
            description = "Updates an existing video based on the provided details.",
            tags = {"Videos"}
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Successfully updated the video",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = VideoDto.class))
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid video data provided"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Video not found"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal server error"
            )
    })
    @PutMapping(value = "/video")
    public ResponseEntity<VideoDto> updateVideo(@RequestBody VideoDto newVideo) {
        Video videoEntity = videoConverter.videoDtoToVideoEntity(newVideo);
        Video updatedVideo = updateThisVideo.updateThisVideo(videoEntity);

        return new ResponseEntity<>(videoConverter.videoEntityToVideoDto(updatedVideo), HttpStatus.OK);
    }
}
