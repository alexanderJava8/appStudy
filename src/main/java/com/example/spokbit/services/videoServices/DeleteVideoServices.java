package com.example.spokbit.services.videoServices;

import com.example.spokbit.entitys.Video;
import com.example.spokbit.exception.exceptionVideo.VideoNotFoundException;
import com.example.spokbit.repository.VideoRepository;
import com.example.spokbit.util.ExceptionVideoMessagesEnum;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeleteVideoServices implements DeleteVideo {
    private final VideoRepository videoRepository;

    public DeleteVideoServices(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    @Override
    public void deleteVideo(long id) {
        existVideo(id);
        videoRepository.deleteById(id);
    }

    private void existVideo(long id) {
        Optional<Video> possibleVideo = videoRepository.findById(id);
        if (possibleVideo.isEmpty()) {
            throw new VideoNotFoundException(ExceptionVideoMessagesEnum.VIDEO_NOT_FOUND.getMessage());
        }
     }
}
