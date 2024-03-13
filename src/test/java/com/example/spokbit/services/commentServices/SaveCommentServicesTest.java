package com.example.spokbit.services.commentServices;

import com.example.spokbit.entitys.Comment;
import com.example.spokbit.entitys.Topic;
import com.example.spokbit.exception.exceptionComment.IncorrectCommentRequestException;
import com.example.spokbit.exception.exceptionTopic.NotFoundTopicExceptions;
import com.example.spokbit.repository.CommentRepository;
import com.example.spokbit.repository.TopicRepository;
import com.example.spokbit.validator.CommentValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class SaveCommentServicesTest {
    @Mock
    private CommentRepository commentRepository;
    @Mock
    private TopicRepository topicRepository;
    @InjectMocks
    private SaveCommentServices saveCommentServices;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveComment() {
        //arrange
        Topic topic = new Topic();
        topic.setId(1L);
        topic.setName("matematica");
        Comment comment = new Comment(1L, "hola", topic);
        when(topicRepository.findById(1L)).thenReturn(Optional.of(topic));
        when(commentRepository.save(comment)).thenReturn(comment);
        //act
        Comment comment1 = saveCommentServices.saveComment(comment);
        //assert
        assertEquals("matematica", comment1.getTopic().getName());
    }

    @Test
    void shouldThrowNotFoundExceptions() {
        //arrange
        Topic topic = new Topic();
        topic.setId(2L);
        topic.setName("matematica");
        Comment comment = new Comment(1L, "hola", topic);
        when(topicRepository.findById(1L)).thenReturn(Optional.of(topic));
        when(commentRepository.save(comment)).thenReturn(comment);
        //act
        //assert
        Exception exception = assertThrows(NotFoundTopicExceptions.class, () -> {
            Comment comment1 = saveCommentServices.saveComment(comment);
        });
    }

    @Test
    void validateCommentEmptyException() {
        //arrange
        Topic topic = new Topic();
        topic.setId(1L);
        topic.setName("matematica");
        Comment comment = new Comment(1L, "", topic);
        when(topicRepository.findById(1L)).thenReturn(Optional.of(topic));

        //act
        Exception exception = assertThrows(IncorrectCommentRequestException.class, () -> {
            CommentValidator.valideteThis(comment);
        });
    }

    @Test
    void validateCommentNullException() {
        //arrange
        Topic topic = new Topic();
        topic.setId(1L);
        topic.setName("matematica");
        Comment comment = new Comment(1L, null, topic);
        when(topicRepository.findById(1L)).thenReturn(Optional.of(topic));

        //act
        Exception exception = assertThrows(IncorrectCommentRequestException.class, () -> {
            CommentValidator.valideteThis(comment);
        });
    }
}