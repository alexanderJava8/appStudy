package com.example.spokbit.services.commentServices;

import com.example.spokbit.dto.CommentToUpdate;
import com.example.spokbit.entitys.Comment;

public interface UpdateComment {
    Comment updateThis(CommentToUpdate comment);
}
