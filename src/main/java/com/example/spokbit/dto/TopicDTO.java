package com.example.spokbit.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TopicDTO {
    private  Long id;
    private  String name;

    public TopicDTO() {
    }

    public TopicDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
