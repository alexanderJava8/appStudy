package com.example.spokbit.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public final class CommentDto {
    private Long id;
    private String comment;
    private TopicDTO topic;

    public CommentDto() {
    }
}
