package com.example.spokbit.services.commentServices;

import com.example.spokbit.dto.CommentDto;
import com.example.spokbit.entitys.Comment;

import java.util.List;

public interface CommentsByTopicId {
    List<Comment> getByTopic(Long id);
}
