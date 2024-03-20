package com.example.spokbit.controller.commentController;

import com.example.spokbit.converter.CommentConverter;
import com.example.spokbit.dto.CommentDto;
import com.example.spokbit.dto.TopicDTO;
import com.example.spokbit.entitys.Comment;
import com.example.spokbit.entitys.Topic;
import com.example.spokbit.services.commentServices.SaveComment;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(SaveCommentController.class)
class SaveCommentControllerTest {
    @MockBean
    private SaveComment saveComment;
    @MockBean
    private CommentConverter commentConverter;
    @InjectMocks
    private SaveCommentController saveCommentController;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void saveComment() throws Exception {
        //arrange
        TopicDTO topicDTO = new TopicDTO();
        topicDTO.setId(1L);
        topicDTO.setName("lenguaje");
        CommentDto commentDto = new CommentDto();
        commentDto.setComment("hi");
        commentDto.setTopic(topicDTO);

        Topic topic = new Topic();
        topic.setId(1L);
        topic.setName("sociales");
        Comment newComment = new Comment();
        newComment.setComment("hi");
        newComment.setTopic(topic);

        when(commentConverter.convertCommentDtoToCommentEntity(commentDto))
                .thenReturn(newComment);
        when(saveComment.saveComment(newComment)).thenReturn(newComment);
        when(commentConverter.convertCommentEntityToCommentDto(newComment))
                .thenReturn(commentDto);
        //assert
        mockMvc.perform(post("/comments")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(commentDto)))
                .andExpect(status().isCreated()).andDo(print());
    }
}