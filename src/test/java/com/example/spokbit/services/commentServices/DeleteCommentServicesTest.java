package com.example.spokbit.services.commentServices;

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
import static org.mockito.Mockito.*;

class DeleteCommentServicesTest {
    @Mock
    private CommentRepository commentRepository;
    @InjectMocks
    private DeleteCommentServices deleteCommentServices;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void delete() {
        //arrange
        Long idComment = 1L;
        Comment comment = new Comment(1L, "papaa", new Topic());
        when(commentRepository.findById(1L)).thenReturn(Optional.of(comment));
        //act
        deleteCommentServices.delete(idComment);
        verify(commentRepository, times(1)).delete(comment);
    }
}