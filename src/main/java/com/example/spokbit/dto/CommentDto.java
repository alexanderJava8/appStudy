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

    public CommentDto(Long id, String comment, TopicDTO topic) {
        this.id = id;
        this.comment = comment;
        this.topic = topic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommentDto that = (CommentDto) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public String toString() {
        return "CommentDto{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                ", topic=" + topic +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
