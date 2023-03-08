package com.example.spokbit.converter;

import com.example.spokbit.dto.TopicDTO;
import com.example.spokbit.entitys.Topic;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;


public final class TopicConverter implements ConverterTopic<Topic, TopicDTO> {

    @Override
    public Topic toEntity(TopicDTO dto) {
        Objects.requireNonNull(dto, "dto is null");
        return Topic.builder()
                .id(dto.getId())
                .comments(dto.getComments())
                .build();
    }

    @Override
    public TopicDTO toDto(Topic entity) {
        Objects.requireNonNull(entity, "entity is null");

        return TopicDTO.builder()
                .id(entity.getId())
                .comments(entity.getComments())
                .build();
    }

    @Override
    public List<TopicDTO> toDto(List<Topic> entitys) {
        return entitys.stream().map(this::toDto).toList();
    }
}
