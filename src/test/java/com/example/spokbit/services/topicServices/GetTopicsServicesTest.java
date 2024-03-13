package com.example.spokbit.services.topicServices;

import com.example.spokbit.entitys.Topic;
import com.example.spokbit.repository.TopicRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class GetTopicsServicesTest {
    @Mock
    TopicRepository topicRepository;

    @InjectMocks
    private GetTopicsServices getTopicsServices;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllTopics() {
        //arrange
        List<Topic> topics = Arrays.asList(
                new Topic(),
                new Topic(),
                new Topic(),
                new Topic()
        );
        Pageable pageable = PageRequest.of(1, 4);
        Page<Topic> topicPage = new PageImpl<>(topics, pageable, topics.size());
        when(topicRepository.findAll(pageable)).thenReturn(topicPage);
        //act
        List<Topic> listTopics = getTopicsServices
                .getAllTopics(pageable);
        //assert
        assertEquals(4, listTopics.size());
    }
}