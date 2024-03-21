package com.example.spokbit.controller.commentController;

import com.example.spokbit.converter.CommentConverter;
import com.example.spokbit.dto.CommentDto;
import com.example.spokbit.dto.TopicDTO;
import com.example.spokbit.entitys.Comment;
import com.example.spokbit.entitys.Topic;
import com.example.spokbit.services.commentServices.CommentsByTopicId;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(GetAllCommentByTopicController.class)
class GetAllCommentByTopicControllerTest {
    @MockBean
    private CommentsByTopicId commentsByTopicId;
    @MockBean
    private CommentConverter commentConverter;
    @InjectMocks
    private GetAllCommentByTopicController getAllCommentByTopicController;
    @Autowired
    private MockMvc mockMvc;

    @Test
    void commentsByTopicId() throws Exception {
        //arrange
        Long id = 1L;

        Topic topic = new Topic();
        topic.setId(1L);
        TopicDTO topicDto = new TopicDTO();
        topicDto.setId(1L);

        Comment comment1 = new Comment();
        comment1.setId(1L);
        comment1.setComment("hi");
        comment1.setTopic(topic);

        Comment comment2 = new Comment();
        comment2.setId(2L);
        comment2.setComment("hi");
        comment2.setTopic(topic);
        List<Comment> commentList = List.of(comment1, comment2);

        CommentDto commentDto1 = new CommentDto();
        commentDto1.setId(1L);
        commentDto1.setComment("hi");
        commentDto1.setTopic(topicDto);

        CommentDto commentDto2 = new CommentDto();
        commentDto2.setId(2L);
        commentDto2.setComment("hi");
        commentDto2.setTopic(topicDto);

        List<CommentDto> commentDtos = List.of(commentDto1, commentDto2);

        when(commentsByTopicId.getByTopic(id)).thenReturn(commentList);
        when(commentConverter.convertCommentEntityToCommentDto(commentList))
                .thenReturn(commentDtos);
        //assert and act
        mockMvc.perform(get("/comments/topicID/{id}", id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()")
                        .value(commentDtos.size()))
                .andDo(print());
    }
}