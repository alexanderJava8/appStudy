package com.example.spokbit.services.videoServices;

import com.example.spokbit.entitys.Video;
import com.example.spokbit.exception.exceptionVideo.VideoNotFoundException;
import com.example.spokbit.repository.VideoRepository;
import com.example.spokbit.util.ExceptionVideoMessagesEnum;
import com.example.spokbit.validator.VideoValidator;
import org.springframework.stereotype.Service;

@Service
public class UpdatedVideoServices implements UpdateVideo{
    private final VideoRepository videoRepository;

    public UpdatedVideoServices(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    @Override
    public Video updateThisVideo(Video video) {
        IsUrlYoutube.isURLYoutube(video.getUrl());
        VideoValidator.valideteThis(video);

        Video videoToUpdate = existVideo(video);
        videoToUpdate.setUrl(video.getUrl());
        videoRepository.save(videoToUpdate);

        return videoToUpdate;
    }

    private Video existVideo(Video video) {
        return videoRepository
                .findById(video.getId())
                .orElseThrow(() -> new VideoNotFoundException(ExceptionVideoMessagesEnum.VIDEO_NOT_FOUND.getMessage()));
    }
}
