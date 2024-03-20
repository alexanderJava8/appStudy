package com.example.spokbit.controller.topicController;

import com.example.spokbit.converter.TopicConverter;
import com.example.spokbit.dto.TopicDTO;
import com.example.spokbit.entitys.Topic;
import com.example.spokbit.services.topicServices.GetTopics;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(GetAllTopicsController.class)
class GetAllTopicsControllerTest {
    @MockBean
    private GetTopics getTopics;
    @MockBean
    private TopicConverter topicConverter;
    @InjectMocks
    private GetAllTopicsController getAllTopicsController;
    @Autowired
    MockMvc mockMvc;

    @Test
    void getAllTopics() throws Exception {
        //arrange
        TopicDTO topicDTO1 = new TopicDTO();
        topicDTO1.setId(1L);
        topicDTO1.setName("lenguaje");

        TopicDTO topicDTO2 = new TopicDTO();
        topicDTO2.setId(2L);
        topicDTO2.setName("matematica");
        List<TopicDTO> topicDTOS = List.of(topicDTO1, topicDTO2);

        Topic topic1 = new Topic();
        topic1.setId(1L);
        topic1.setName("lenguaje");

        Topic topic2 = new Topic();
        topic2.setId(2L);
        topic2.setName("matematica");
        List<Topic> topics = List.of(topic1, topic2);

        Pageable pageable = PageRequest.of(0, 15);
        when(getTopics.getAllTopics(pageable)).thenReturn(topics);
        when(topicConverter.convertListTopicToListTopicDto(topics)).thenReturn(topicDTOS);
        //assert
        mockMvc.perform(get("/topics"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(topicDTOS.size()))
                .andDo(print());
     }
}