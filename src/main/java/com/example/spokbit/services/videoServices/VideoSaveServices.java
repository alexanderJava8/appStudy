package com.example.spokbit.services.videoServices;

import com.example.spokbit.entitys.Video;
import com.example.spokbit.repository.VideoRepository;
import org.springframework.stereotype.Service;

@Service
public class VideoSaveServices implements SaveVideo {
    private final VideoRepository videoRepository;

    public VideoSaveServices(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    @Override
    public Video save(Video video) {
        String newUrl = URLModifier.modifyUrl(video.getUrl());
        video.setUrl(newUrl);

        return videoRepository.save(video);
    }
}
