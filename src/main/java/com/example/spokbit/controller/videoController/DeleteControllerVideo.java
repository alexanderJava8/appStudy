package com.example.spokbit.controller.videoController;

import com.example.spokbit.services.videoServices.DeleteVideo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"http://localhost:5500", "http://127.0.0.1:5500"})
public class DeleteControllerVideo {
    private final DeleteVideo deleteVideo;

    public DeleteControllerVideo(DeleteVideo deleteVideo) {
        this.deleteVideo = deleteVideo;
    }

    @DeleteMapping(value = "/video/{id}")
    public ResponseEntity<Void> deleteVideo(@PathVariable("id") long id) {
        deleteVideo.deleteVideo(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
