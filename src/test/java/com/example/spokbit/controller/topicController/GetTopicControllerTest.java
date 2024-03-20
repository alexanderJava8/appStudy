package com.example.spokbit.controller.topicController;

import com.example.spokbit.converter.TopicConverter;
import com.example.spokbit.dto.TopicDTO;
import com.example.spokbit.entitys.Topic;
import com.example.spokbit.services.topicServices.GetTopic;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(GetTopicController.class)
class GetTopicControllerTest {
    @MockBean
    private GetTopic getTopic;
    @MockBean
    private TopicConverter topicConverter;
    @InjectMocks
    private GetTopicController getTopicController;
    @Autowired
    private MockMvc mockMvc;

    @Test
    void getTopic() throws Exception {
        //arrange
        Long id = 1L;

        Topic topic = new Topic();
        topic.setId(1L);
        topic.setName("matematica");

        TopicDTO topicDTO = new TopicDTO();
        topicDTO.setId(1L);
        topicDTO.setName("matematica");

        when(getTopic.ById(id)).thenReturn(topic);
        when(topicConverter.convertTopicToTopicDto(topic)).thenReturn(topicDTO);
        //assert
        MvcResult result = mockMvc.perform(get("/topics/{topicId}", id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(topicDTO.getId()))
                .andExpect(jsonPath("$.name").value(topicDTO.getName()))
                .andReturn();
    }
}