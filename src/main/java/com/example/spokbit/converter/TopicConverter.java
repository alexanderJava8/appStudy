package com.example.spokbit.converter;

import com.example.spokbit.dto.TopicDTO;
import com.example.spokbit.entitys.Topic;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TopicConverter {
    private final ModelMapper modelMapper;

    @Autowired
    public TopicConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public TopicDTO convertTopicToTopicDto(Topic topic) {
        return modelMapper.map(topic, TopicDTO.class);
    }

    public List<TopicDTO> convertListTopicToListTopicDto(List<Topic> topics) {
        return topics.stream().map(element -> modelMapper.map(element, TopicDTO.class)).toList();
    }

    public Topic convertTopicDtoToTopicEntity(TopicDTO topicDTO) {
        return modelMapper.map(topicDTO, Topic.class);
    }
}
