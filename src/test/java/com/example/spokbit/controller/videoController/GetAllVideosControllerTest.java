package com.example.spokbit.controller.videoController;

import com.example.spokbit.converter.VideoConverter;
import com.example.spokbit.dto.VideoDto;
import com.example.spokbit.entitys.Video;
import com.example.spokbit.services.videoServices.GetAllVideos;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@WebMvcTest(GetAllVideosController.class)
class GetAllVideosControllerTest {
    @MockBean
    private GetAllVideos getAllVideos;
    @MockBean
    private VideoConverter videoConverter;
    @InjectMocks
    private GetAllVideosController getAllVideosController;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private MockMvc mockMvc;

    @Test
    void allVideos() throws Exception {
        //arrange
        Video video1 = new Video();
        video1.setId(1L);
        video1.setUrl("https://www.youtube.com/watch?v=7gZwfwLkwmw");
        Video video2 = new Video();
        video2.setId(2L);
        video2.setUrl("https://www.youtube.com/watch?v=7gZwfwLkwmw");
        VideoDto videoDto1 = new VideoDto();
        videoDto1.setId(1L);
        videoDto1.setUrl("https://www.youtube.com/watch?v=7gZwfwLkwmw");
        VideoDto videoDto2 = new VideoDto();
        videoDto1.setId(2L);
        videoDto1.setUrl("https://www.youtube.com/watch?v=7gZwfwLkwmw");
        List<VideoDto> videoDtos = List.of(videoDto1, videoDto2);
        List<Video> videosEntity = Arrays.asList(video1, video2);
        when(getAllVideos.getAllVideos()).thenReturn(videosEntity);
        when(videoConverter.videoEntityToVideoDto(videosEntity)).thenReturn(videoDtos);
        //act
        MvcResult mvcResult = mockMvc.perform(get("/videos"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(videoDtos.size()))
                .andReturn();
    }
}