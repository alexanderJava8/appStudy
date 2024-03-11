package com.example.spokbit.services.videoServices;

import com.example.spokbit.entitys.Video;
import com.example.spokbit.repository.VideoRepository;
import com.example.spokbit.validator.VideoValidator;
import org.springframework.stereotype.Service;

@Service
public class VideoSaveServices implements SaveVideo {
    private final VideoRepository videoRepository;

    public VideoSaveServices(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    @Override
    public Video save(Video video) {
        IsUrlYoutube.isURLYoutube(video.getUrl());
        VideoValidator.valideteThis(video);

        String newUrl = URLModifier.modifyUrl(video.getUrl());
        video.setUrl(newUrl);

        return videoRepository.save(video);
    }
}
