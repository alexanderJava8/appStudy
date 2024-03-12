package com.example.spokbit.services.videoServices;

import com.example.spokbit.entitys.Video;
import com.example.spokbit.repository.VideoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GetAllVideosServicesTest {
    @Mock
    private VideoRepository videoRepository;

    @InjectMocks
    private GetAllVideosServices getAllVideosServices;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllVideos() {
        //arrange
        List<Video> videos = Arrays.asList(
                new Video(1L, "https://www.youtube.com/watch?v=Z3L5M7GHAkw"),
                new Video(2L, "https://www.youtube.com/watch?v=l98w9OSKVNA"),
                new Video(3L, "https://www.youtube.com/watch?v=q1pBwQl6zZ0")
        );
        when(videoRepository.findAll()).thenReturn(videos);
        //act
        List<Video> listVideos = getAllVideosServices.getAllVideos();
        //assert
        assertEquals(3, listVideos.size());
    }

    @Test
    void getAllVideosListEmpty() {
        //arrange
        when(videoRepository.findAll()).thenReturn(Collections.emptyList());
        //act
        List<Video> videos = getAllVideosServices.getAllVideos();
        //assert
        assertEquals(Collections.emptyList(), videos);
    }

    @Test
    void getAllVideos_verifyRepositoryCall() {
        //arrange
        List<Video> videos = Arrays.asList(
                new Video(1L, "https://www.youtube.com/watch?v=Z3L5M7GHAkw"),
                new Video(2L, "https://www.youtube.com/watch?v=l98w9OSKVNA"),
                new Video(3L, "https://www.youtube.com/watch?v=q1pBwQl6zZ0")
        );
        when(videoRepository.findAll()).thenReturn(videos);
        //act
        getAllVideosServices.getAllVideos();
        //assert
        verify(videoRepository, times(1)).findAll();
    }
}