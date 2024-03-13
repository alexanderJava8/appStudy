package com.example.spokbit.services.commentServices;

import com.example.spokbit.dto.CommentToUpdate;
import com.example.spokbit.entitys.Comment;
import com.example.spokbit.entitys.Topic;
import com.example.spokbit.repository.CommentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class UpdateCommentServicesTest {
    @Mock
    private CommentRepository commentRepository;
    @InjectMocks
    private UpdateCommentServices updateCommentServices;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void updateThis() {
        //arrange
        Topic topic = new Topic();
        topic.setId(1L);
        topic.setName("mates");
        Comment comment = new Comment(1L, "hi", topic);
        when(commentRepository.findById(1L)).thenReturn(Optional.of(comment));
        when(commentRepository.save(comment)).thenReturn(comment);
        //act
        CommentToUpdate newComment = new CommentToUpdate(1L, "noHi");
        Comment commentUpdated = updateCommentServices.updateThis(newComment);
        //assert
        assertEquals("noHi", comment.getComment());
    }
}