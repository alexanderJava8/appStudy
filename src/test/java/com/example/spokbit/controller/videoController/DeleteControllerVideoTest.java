package com.example.spokbit.controller.videoController;

import com.example.spokbit.services.videoServices.DeleteVideo;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DeleteControllerVideo.class)
class DeleteControllerVideoTest {
    @MockBean
    private DeleteVideo deleteVideo;
    @InjectMocks
    private DeleteControllerVideo deleteControllerVideo;
    @Autowired
    private MockMvc mockMvc;

    @Test
    void deleteVideo() throws Exception {
        //arrange
        long id = 1L;
        doNothing().when(deleteVideo).deleteVideo(id);
        mockMvc.perform(delete("/video/{id}", id))
                .andExpect(status().isOk())
                .andDo(print());
    }
}