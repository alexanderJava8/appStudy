package com.example.spokbit.controller.topicController;

import com.example.spokbit.converter.TopicConverter;
import com.example.spokbit.dto.TopicDTO;
import com.example.spokbit.entitys.Topic;
import com.example.spokbit.services.topicServices.SaveTopic;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SaveTopicController.class)
class SaveTopicControllerTest {
    @MockBean
    private SaveTopic saveTopic;
    @MockBean
    private TopicConverter topicConverter;
    @InjectMocks
    private SaveTopicController saveTopicController;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void saveTopic() throws Exception {
        //arrange
        TopicDTO topicDTO = new TopicDTO();
        topicDTO.setName("matematica");
        Topic topicSave = new Topic();
        topicSave.setName("matematica");
        when(topicConverter.convertTopicDtoToTopicEntity(topicDTO))
                .thenReturn(topicSave);
        when(saveTopic.save(topicSave)).thenReturn(topicSave);
        //act
        mockMvc.perform(post("/topics")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(topicDTO)))
                .andExpect(status().isCreated()).andDo(print());
    }
}