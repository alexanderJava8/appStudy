package com.example.spokbit.dto;

import lombok.*;

@Getter
@Builder
public final class TopicDTO {
    private final Long id;
    private final String comments;

    public TopicDTO(final Long id, final String comments) {
        this.id = id;
        this.comments = comments;
    }
}
