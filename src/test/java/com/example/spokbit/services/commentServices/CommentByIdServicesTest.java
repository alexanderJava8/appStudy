package com.example.spokbit.services.commentServices;

import com.example.spokbit.entitys.Comment;
import com.example.spokbit.entitys.Topic;
import com.example.spokbit.exception.exceptionComment.NotFoundCommentException;
import com.example.spokbit.exception.exceptionTopic.NotFoundTopicExceptions;
import com.example.spokbit.repository.CommentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class CommentByIdServicesTest {
    @Mock
    private CommentRepository commentRepository;
    @InjectMocks
    private CommentByIdServices commentByIdServices;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getComment() {
        //arrange
        Comment comment = new Comment(1L, "holas", new Topic());
        when(commentRepository.findById(1L)).thenReturn(Optional.of(comment));
        //act
        Comment comment1 = commentByIdServices.getComment(1L);
        //assert
        assertEquals(1, comment1.getId());
        assertEquals("holas", comment1.getComment());
    }

    @Test
    void shouldThrowNotFoundCommentException() {
        //arrange
        Comment comment = new Comment(1L, "holas", new Topic());
        when(commentRepository.findById(1L)).thenReturn(Optional.of(comment));
        //assert
        Exception exception = assertThrows(NotFoundCommentException.class, () -> {
            commentByIdServices.getComment(2L);
        });
    }
}