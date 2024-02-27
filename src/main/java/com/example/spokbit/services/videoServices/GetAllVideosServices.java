package com.example.spokbit.services.videoServices;

import com.example.spokbit.entitys.Video;
import com.example.spokbit.repository.VideoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllVideosServices implements GetAllVideos {
    private final VideoRepository videoRepository;

    public GetAllVideosServices(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    @Override
    public List<Video> getAllVideos() {
        return videoRepository.findAll();
    }
}
