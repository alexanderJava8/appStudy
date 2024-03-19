package com.example.spokbit.controller.videoController;

import com.example.spokbit.converter.VideoConverter;
import com.example.spokbit.dto.VideoDto;
import com.example.spokbit.entitys.Video;
import com.example.spokbit.services.videoServices.UpdateVideo;
import com.fasterxml.jackson.core.JsonProcessingException;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

@WebMvcTest(UpdateVideoController.class)
class UpdateVideoControllerTest {
    @MockBean
    private UpdateVideo updateThisVideo;
    @MockBean
    private VideoConverter videoConverter;
    @InjectMocks
    private UpdateVideoController updateVideoController;
    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
    }

    @Test
    void updateVideo() throws Exception {
        //arrange
        VideoDto videoDto = new VideoDto();
        videoDto.setId(1L);
        videoDto.setUrl("https://www.youtube.com/watch?v=gGtCgCed6D8");
        Video videoEntity = videoConverter.videoDtoToVideoEntity(videoDto);
        Video updatedVideo = new Video();
        updatedVideo.setId(1L);
        updatedVideo.setUrl("https://www.youtube.com/watch?v=gGtCgCed6D8");
        given(updateThisVideo.updateThisVideo(videoEntity)).willReturn(updatedVideo);
        //act
        MvcResult mvcResult = mockMvc.perform(put("/video")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(videoDto)))
                .andReturn();
        //assert
        assertEquals(200, mvcResult.getResponse().getStatus());
        verify(videoConverter).videoDtoToVideoEntity(videoDto);
        verify(videoConverter).videoEntityToVideoDto(updatedVideo);
    }
}