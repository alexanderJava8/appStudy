package com.example.spokbit.controller.commentController;

import com.example.spokbit.converter.CommentConverter;
import com.example.spokbit.dto.CommentToUpdate;
import com.example.spokbit.entitys.Comment;
import com.example.spokbit.services.commentServices.UpdateComment;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@WebMvcTest(UpdateCommentController.class)
class UpdateCommentControllerTest {
    @MockBean
    private UpdateComment update;
    @MockBean
    private CommentConverter converter;
    @InjectMocks
    private UpdateCommentController updateCommentController;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void updateComment() throws Exception {
        //arrange
        CommentToUpdate comment = new CommentToUpdate(1L, "nuevo");
        Comment updatedComment = new Comment();
        updatedComment.setId(1L);
        updatedComment.setComment("nuevo");
        when(update.updateThis(comment)).thenReturn(updatedComment);
        //assert and act
        mockMvc.perform(put("/comments")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comment)))
                .andExpect(status().isOk());
    }
}