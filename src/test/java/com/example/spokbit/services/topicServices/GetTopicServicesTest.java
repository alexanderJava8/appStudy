package com.example.spokbit.services.topicServices;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Optional;

import com.example.spokbit.exception.exceptionTopic.NotFoundTopicExceptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.spokbit.entitys.Topic;
import com.example.spokbit.repository.TopicRepository;

public class GetTopicServicesTest {
    @Mock
    private TopicRepository topicRepository;

    @InjectMocks
    private GetTopicServices getTopicServices;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void ById() {
        //arrange
        Topic topic = new Topic();
        topic.setId(1l);
        topic.setName("filosofia");
        when(topicRepository.findById(1L)).thenReturn(Optional.of(topic));
        //act
        Topic retrievedTopic = getTopicServices.ById(1L);
        //assert
        assertEquals("filosofia", retrievedTopic.getName());
    }

    @Test
    void shouldThrowNotFoundTopicException() {
        //arrange
        Topic topic = new Topic();
        topic.setId(1L);
        topic.setName("mate");
        when(topicRepository.findById(1L)).thenReturn(Optional.of(topic));
        //act and assert
        Exception exception = assertThrows(NotFoundTopicExceptions.class, () -> {
            getTopicServices.ById(3L);
        });
        assertEquals("Topic Does Not Exist", exception.getMessage());
    }
}
