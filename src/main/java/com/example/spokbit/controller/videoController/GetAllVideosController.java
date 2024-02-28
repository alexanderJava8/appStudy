package com.example.spokbit.controller.videoController;

import com.example.spokbit.converter.VideoConverter;
import com.example.spokbit.dto.VideoDto;
import com.example.spokbit.entitys.Video;
import com.example.spokbit.services.videoServices.GetAllVideos;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:5500/", "http://127.0.0.1:5500/"})
public class GetAllVideosController {
    private final GetAllVideos getAllVideos;
    private final VideoConverter videoConverter;

    public GetAllVideosController(GetAllVideos getAllVideos, VideoConverter videoConverter) {
        this.getAllVideos = getAllVideos;
        this.videoConverter = videoConverter;
    }

    @GetMapping(value = "/videos")
    public ResponseEntity<List<VideoDto>> allVideos() {
        List<Video> videosEntity = getAllVideos.getAllVideos();
        List<VideoDto> videosDto = videoConverter.videoEntityToVideoDto(videosEntity);

        return new ResponseEntity<>(videosDto, HttpStatus.OK);
    }
}
