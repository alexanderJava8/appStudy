package com.example.spokbit.services.topicServices;

import com.example.spokbit.entitys.Topic;
import com.example.spokbit.exception.exceptionTopic.NotFoundTopicExceptions;
import com.example.spokbit.repository.TopicRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DeleteTopicServicesTest {
    @Mock
    private TopicRepository topicRepository;

    @InjectMocks
    private DeleteTopicServices deleteTopicServices;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void theNextTopicBy() {
        //arrange
        Long idTopic = 1L;
        Topic topic = new Topic();
        topic.setId(idTopic);
        topic.setName("sociales");
        when(topicRepository.findById(1L)).thenReturn(Optional.of(topic));
        //act
        deleteTopicServices.theNextTopicBy(1L);
        //assert
        verify(topicRepository, times(1)).delete(topic);
    }

    @Test
    void shouldThrowNotFoundException() {
        //arrange
        Long idTopic = 1L;
        Topic topic = new Topic();
        topic.setId(idTopic);
        topic.setName("sociales");
        when(topicRepository.findById(1L)).thenReturn(Optional.of(topic));
        //act
        //assert
        Exception exception = assertThrows(NotFoundTopicExceptions.class, () -> {
            deleteTopicServices.theNextTopicBy(2L);
        });
        assertEquals("Topic Does Not Exist", exception.getMessage());
    }
}