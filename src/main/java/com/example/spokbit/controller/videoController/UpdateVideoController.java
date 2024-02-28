package com.example.spokbit.controller.videoController;

import com.example.spokbit.converter.VideoConverter;
import com.example.spokbit.dto.VideoDto;
import com.example.spokbit.entitys.Video;
import com.example.spokbit.services.videoServices.UpdateVideo;
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

    @PutMapping(value = "/video")
    public ResponseEntity<VideoDto> updateVideo(@RequestBody VideoDto newVideo) {
        Video videoEntity = videoConverter.videoDtoToVideoEntity(newVideo);
        Video updatedVideo = updateThisVideo.updateThisVideo(videoEntity);

        return new ResponseEntity<>(videoConverter.videoEntityToVideoDto(updatedVideo), HttpStatus.OK);
    }
}
