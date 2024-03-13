package com.example.spokbit.services.topicServices;

import com.example.spokbit.entitys.Topic;
import com.example.spokbit.repository.TopicRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UpdateTopicServicesTest {
    @Mock
    private TopicRepository topicRepository;

    @InjectMocks
    private UpdateTopicServices updateTopicServices;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void theNextTest() {
        //arrange
        Topic topic = new Topic();
        topic.setId(1L);
        topic.setName("sociales");
        when(topicRepository.findById(1L))
                .thenReturn(Optional.of(topic));

        Topic topicUpdate = new Topic();
        topicUpdate.setId(1L);
        topicUpdate.setName("lenguaje");
        when(topicRepository.save(topicUpdate))
                .thenReturn(topicUpdate);
        //act
        Topic topic1 = updateTopicServices
                .theNext(topicUpdate);
        //assert
        assertEquals("lenguaje", topicUpdate.getName());
        verify(topicRepository, times(1)).findById(1L);
    }
}