package com.example.spokbit.services.videoServices;

import com.example.spokbit.entitys.Video;
import com.example.spokbit.repository.VideoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class UpdatedVideoServicesTest {
    @Mock
    private VideoRepository videoRepository;

    @InjectMocks
    private UpdatedVideoServices updatedVideoServices;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testUpdateVideo() {
        //arrange
        Video video = new Video(1L, "https://www.youtube.com/watch?v=5RCD3kThsW0");
        when(videoRepository.findById(1L)).thenReturn(Optional.of(video));
        //act
        Video videoUpdated = updatedVideoServices.updateThisVideo(video);
        //assert
        assertEquals(video.getUrl(), videoUpdated.getUrl());
    }

}