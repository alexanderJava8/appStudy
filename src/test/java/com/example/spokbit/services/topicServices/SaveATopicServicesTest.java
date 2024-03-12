package com.example.spokbit.services.topicServices;

import com.example.spokbit.entitys.Comment;
import com.example.spokbit.entitys.Topic;
import com.example.spokbit.entitys.Video;
import com.example.spokbit.exception.exceptionTopic.IncorrectTopicRequestException;
import com.example.spokbit.repository.TopicRepository;
import com.example.spokbit.validator.TopicValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class SaveATopicServicesTest {
    @Mock
    private TopicRepository topicRepository;

    @InjectMocks
    private SaveATopicServices saveATopicServices;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void save() {
        //arrange
        Topic topic = new Topic();
        topic.setName("topic");
        when(topicRepository.save(topic))
                .thenReturn(topic);
        //act
        Topic topic1 = saveATopicServices.save(topic);
        //assert
        assertEquals(topic1.getName(), topic.getName());
    }

    @Test
    void topicValidatorTest() {
        //arrange
        Topic topic = new Topic();
        topic.setName("mate");
        topic.setId(1L);
        //act
        boolean isValidSubject = TopicValidator.valideteThis(topic);
        //assert
        assertTrue(isValidSubject);
    }

    @Test
    void save_InvalidTopic_ThrowsException() {
        //arrange
        Topic topic = new Topic();
        topic.setName(null);
        // act and assert
        assertThrows(IncorrectTopicRequestException.class, () -> {
            Topic topic1 = saveATopicServices.save(topic);
        });
    }
}