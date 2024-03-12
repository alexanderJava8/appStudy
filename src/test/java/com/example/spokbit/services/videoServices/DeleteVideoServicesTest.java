package com.example.spokbit.services.videoServices;

import com.example.spokbit.entitys.Video;
import com.example.spokbit.exception.exceptionVideo.VideoNotFoundException;
import com.example.spokbit.repository.VideoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DeleteVideoServicesTest {
    @Mock
    private VideoRepository videoRepository;

    @InjectMocks
    private DeleteVideoServices deleteVideoServices;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deleteVideo() {
        //arrange
        Video video = new Video(1L,
                "https://www.youtube.com/watch?v=Z3L5M7GHAkw");
        when(videoRepository.findById(1L))
                .thenReturn(Optional.of(video));
        //act
        deleteVideoServices.deleteVideo(video.getId());
        //assert

        verify(videoRepository, times(1))
                .deleteById(video.getId());
    }

    @Test
    void deleteVideo_nonExistingVideo() {
        //arrange
        Video video = new Video(3L,
                "https://www.youtube.com/watch?v=Z3L5M7GHAkw");
        when(videoRepository.findById(video.getId()))
                .thenReturn(Optional.empty());

        //assert
        assertThrows(VideoNotFoundException.class, () -> {
            deleteVideoServices.deleteVideo(3L);
        });
    }
}