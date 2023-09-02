package com.example.spokbit.converter;

import com.example.spokbit.dto.CommentDto;
import com.example.spokbit.entitys.Comment;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommentConverter {
    private ModelMapper modelMapper;

    @Autowired
    public CommentConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public CommentDto convertCommentEntityToCommentDto(Comment comment) {
        return modelMapper.map(comment, CommentDto.class);
    }

    public Comment convertCommentDtoToCommentEntity(CommentDto commentDto) {
        return modelMapper.map(commentDto, Comment.class);
    }
}
