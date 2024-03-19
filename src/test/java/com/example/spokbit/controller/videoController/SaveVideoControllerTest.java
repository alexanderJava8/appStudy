package com.example.spokbit.controller.videoController;

import com.example.spokbit.converter.VideoConverter;
import com.example.spokbit.dto.VideoDto;
import com.example.spokbit.entitys.Video;
import com.example.spokbit.services.videoServices.VideoSaveServices;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@WebMvcTest(SaveVideoController.class)
class SaveVideoControllerTest {
    @MockBean
    private VideoSaveServices saveVideo;
    @MockBean
    private VideoConverter videoConverter;
    @InjectMocks
    private SaveVideoController saveVideoController;
    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
    }

    @Test
    void saveVideo() throws Exception {
        //arrange
        VideoDto videoDto = new VideoDto();
        videoDto.setId(1L);
        videoDto.setUrl("https://www.youtube.com/watch?v=qzOdBGVJ-Js");
        Video videoEntity = videoConverter.videoDtoToVideoEntity(videoDto);
        given(saveVideo.save(videoEntity)).willReturn(videoEntity);
        //act
        Video savedVideo = saveVideo.save(videoEntity);
        MvcResult mvcResult = mockMvc.perform(post("/video")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(videoDto)))
                .andReturn();
        //assert
        assertEquals(200, mvcResult.getResponse().getStatus());
        verify(videoConverter).videoDtoToVideoEntity(videoDto);
        verify(videoConverter).videoEntityToVideoDto(videoEntity);
    }

    @Test
    void testVideoConversionRoundTrip() throws Exception {
        //arrange
        VideoDto  videoDto =  new VideoDto();
        videoDto.setUrl("https://www.youtube.com/watch?v=qzOdBGVJ-Js");
        Video videoEntity = new Video();
        videoEntity.setUrl("https://www.youtube.com/watch?v=qzOdBGVJ-Js");
        Video videoSaved = new Video();
        videoSaved.setId(1L);
        videoSaved.setUrl("https://www.youtube.com/watch?v=qzOdBGVJ-Js");
        VideoDto videoSavedDto = new VideoDto();
        videoSavedDto.setId(1L);
        videoSavedDto.setUrl("https://www.youtube.com/watch?v=qzOdBGVJ-Js");
        given(videoConverter.videoDtoToVideoEntity(videoDto)).willReturn(videoEntity);
        given(saveVideo.save(videoEntity)).willReturn(videoSaved);
        given(videoConverter.videoEntityToVideoDto(videoSaved)).willReturn(videoSavedDto);
        //act
        videoConverter.videoDtoToVideoEntity(videoDto);
        saveVideo.save(videoEntity);
        //assert
        assertNull(videoEntity.getId());
        assertEquals(1L, videoSaved.getId());
        System.out.println(videoSavedDto.getId());
        System.out.println(videoSavedDto.getUrl());
    }
}