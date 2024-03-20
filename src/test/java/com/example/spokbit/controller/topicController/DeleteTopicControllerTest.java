package com.example.spokbit.controller.topicController;

import com.example.spokbit.services.topicServices.DeleteTopic;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DeleteTopicController.class)
class DeleteTopicControllerTest {
    @MockBean
    private DeleteTopic deleteTopic;
    @InjectMocks
    private DeleteTopicController deleteTopicController;
    @Autowired
    private MockMvc mockMvc;

    @Test
    void deleteTopic() throws Exception {
        //arrange
        Long id = 1L;
        //assert
        doNothing().when(deleteTopic).theNextTopicBy(id);
        mockMvc.perform(delete("/topics/{topicId}", id))
                .andExpect(status().isOk())
                .andDo(print());
    }
}