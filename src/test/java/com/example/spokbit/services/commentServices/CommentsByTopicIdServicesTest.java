package com.example.spokbit.services.commentServices;

import com.example.spokbit.entitys.Comment;
import com.example.spokbit.entitys.Topic;
import com.example.spokbit.repository.CommentRepository;
import com.example.spokbit.repository.TopicRepository;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CommentsByTopicIdServicesTest {
    @Mock
    private CommentRepository commentRepository;
    @Mock
    private TopicRepository topicRepository;
    @InjectMocks
    private CommentsByTopicIdServices commentsByTopicIdServices;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getByTopic() {
        //arrange
        Long id = 1L;
        Topic topic = new Topic();
        topic.setId(1L);
        topic.setName("matematica");
        Comment comment = new Comment(1L, "creer", topic);
        List<Comment> comments = List.of(comment);
        when(topicRepository.findById(1L)).thenReturn(Optional.of(topic));
        when(commentRepository.findCommentsByTopicId(1L)).thenReturn(comments);
        //act
        List<Comment> comments1 = commentsByTopicIdServices.getByTopic(1L);
        //assert
        verify(topicRepository, times(1)).findById(1L);
        verify(commentRepository, times(1)).findCommentsByTopicId(1L);
        assertEquals(1, comments1.size());
        assertEquals("creer", comments1.get(0).getComment());
        assertEquals(1, comments1.get(0).getId());
    }
}