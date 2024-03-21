package com.example.spokbit.controller.commentController;

import com.example.spokbit.services.commentServices.DeleteComment;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DeleteCommentController.class)
class DeleteCommentControllerTest {
    @MockBean
    private DeleteComment deleteComment;
    @InjectMocks
    private DeleteCommentController deleteCommentController;
    @Autowired
    private MockMvc mockMvc;

    @Test
    void deleteComment() throws Exception {
        //arrange
        Long id = 1L;
        doNothing().when(deleteComment).delete(id);
        mockMvc.perform(delete("/comments/{id}", id))
                .andExpect(status().isOk())
                .andDo(print());
    }
}