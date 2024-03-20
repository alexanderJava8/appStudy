package com.example.spokbit.controller.topicController;

import com.example.spokbit.converter.TopicConverter;
import com.example.spokbit.dto.TopicDTO;
import com.example.spokbit.entitys.Topic;
import com.example.spokbit.services.topicServices.UpdateTopic;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import com.fasterxml.jackson.core.type.TypeReference;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UpdateTopicController.class)
class UpdateTopicControllerTest {
    @MockBean
    private UpdateTopic updateTopic;
    @MockBean
    private TopicConverter topicConverter;
    @InjectMocks
    private UpdateTopicController updateTopicController;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void updateTopic() throws Exception {
        //assert
        TopicDTO topic = new TopicDTO();
        topic.setId(1L);
        topic.setName("matematica");

        Topic topicEntity = new Topic();
        topicEntity.setId(1L);
        topicEntity.setName("matematica");

        HttpStatus status = HttpStatus.OK;
        ResponseEntity<TopicDTO> response = new ResponseEntity<>(topic, status);

        when(topicConverter.convertTopicDtoToTopicEntity(topic)).thenReturn(topicEntity);
        when(updateTopic.theNext(topicEntity)).thenReturn(topicEntity);
        when(topicConverter.convertTopicToTopicDto(topicEntity)).thenReturn(topic);
        //assert
        MvcResult mvcResult =  mockMvc.perform(put("/topics")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(topic)))
                .andExpect(status().isOk()).andReturn();
    }
}