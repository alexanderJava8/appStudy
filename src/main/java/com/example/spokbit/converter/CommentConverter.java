package com.example.spokbit.converter;

import com.example.spokbit.dto.CommentDto;
import com.example.spokbit.entitys.Comment;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CommentConverter {
    private ModelMapper modelMapper;

    public CommentConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public CommentDto convertCommentEntityToCommentDto(Comment comment) {
        return modelMapper.map(comment, CommentDto.class);
    }

    public Comment convertCommentDtoToCommentEntity(CommentDto commentDto) {
        return modelMapper.map(commentDto, Comment.class);
    }

    public List<CommentDto> convertCommentEntityToCommentDto(List<Comment> comments) {
        return comments.stream().map(comment -> convertCommentEntityToCommentDto(comment)).toList();
    }
}
