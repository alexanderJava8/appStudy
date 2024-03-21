package com.example.spokbit.controller.commentController;

import com.example.spokbit.converter.CommentConverter;
import com.example.spokbit.dto.CommentDto;
import com.example.spokbit.entitys.Comment;
import com.example.spokbit.services.commentServices.CommentById;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@WebMvcTest(GetCommentByIdController.class)
class GetCommentByIdControllerTest {
    @MockBean
    private CommentById commentById;
    @MockBean
    private CommentConverter commentConverter;
    @InjectMocks
    private GetCommentByIdController getCommentByIdController;
    @Autowired
    private MockMvc mockMvc;

    @Test
    void getComment() throws Exception {
        //arrange
        Comment comment = new Comment();
        comment.setId(1L);
        comment.setComment("hola");

        CommentDto commentDto = new CommentDto();
        commentDto.setId(2L);
        commentDto.setComment("hola");

        when(commentById.getComment(1L)).thenReturn(comment);
        when(commentConverter.convertCommentEntityToCommentDto(comment))
                .thenReturn(commentDto);
        //asert and act
        mockMvc.perform(get("/comments/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id")
                        .value(commentDto.getId())).andDo(print());
    }
}