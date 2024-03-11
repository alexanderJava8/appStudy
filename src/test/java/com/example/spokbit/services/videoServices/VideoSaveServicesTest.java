package com.example.spokbit.services.videoServices;

import com.example.spokbit.entitys.Video;
import com.example.spokbit.exception.exceptionVideo.IncorrectVideoRequestException;
import com.example.spokbit.exception.exceptionVideo.URLNotFromYoutubeException;
import com.example.spokbit.repository.VideoRepository;
import com.example.spokbit.validator.VideoValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.net.MalformedURLException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class VideoSaveServicesTest {
    @Mock
    private VideoRepository videoRepository;

    @InjectMocks
    private VideoSaveServices videoSaveServices;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void isUrlYoutube() {
        //arrange
        String url = "https://ww.youtube.com/watch?v=5RCD3kThsW0";
        //assert
        assertThrows(URLNotFromYoutubeException.class, () -> {
           IsUrlYoutube.isURLYoutube(url);
        });
    }

    @Test
    void valideteVideo() {
        //arrange
        Video video = new Video(1L, null);
        //assert
        assertThrows(IncorrectVideoRequestException.class, () -> {
            VideoValidator.valideteThis(video);
        });
    }

    @Test
    void modifyUrl() {
        //arrange
        String url = "https://www.youtube.com/watch?v=5RCD3kThsW0";
        //act
        //assert
        assertEquals("https://www.youtube.com/embed/5RCD3kThsW0",
                URLModifier.modifyUrl(url));
    }

    @Test
    void saveVideo() {
        //arrange
        Video video = new Video(1L, "https://www.youtube.com/watch?v=5RCD3kThsW0");
        when(videoRepository.save(video)).thenReturn(video);
        //act
        Video savedVideo = videoSaveServices.save(video);
        //assert
        assertEquals("https://www.youtube.com/embed/5RCD3kThsW0", savedVideo.getUrl());
    }
}
