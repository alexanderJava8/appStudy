package com.example.spokbit.controller.videoController;

import com.example.spokbit.converter.VideoConverter;
import com.example.spokbit.dto.VideoDto;
import com.example.spokbit.entitys.Video;
import com.example.spokbit.services.videoServices.SaveVideo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
/*esto es solo prueba, eliminarlo despues*/
@CrossOrigin(origins = {"http://localhost:5500/", "http://127.0.0.1:5500/"})
public class SaveVideoController {
    private final SaveVideo saveVideo;
    private final VideoConverter videoConverter;

    public SaveVideoController(SaveVideo saveVideo, VideoConverter videoConverter) {
        this.saveVideo = saveVideo;
        this.videoConverter = videoConverter;
    }

    @PostMapping(value = "/video")
    public ResponseEntity<VideoDto> saveVideo(@RequestBody VideoDto video) {
        Video videoEntity = videoConverter.videoDtoToVideoEntity(video);
        Video videoSaved = saveVideo.save(videoEntity);

        return new ResponseEntity<>(videoConverter.videoEntityToVideoDto(videoSaved), HttpStatus.OK);
    }
}
