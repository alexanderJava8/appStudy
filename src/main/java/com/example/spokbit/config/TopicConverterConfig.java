package com.example.spokbit.config;

import com.example.spokbit.converter.ConverterTopic;
import com.example.spokbit.converter.TopicConverter;
import com.example.spokbit.dto.TopicDTO;
import com.example.spokbit.entitys.Topic;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class TopicConverterConfig {
    @Bean
    public ConverterTopic<Topic, TopicDTO> converterTopic() {
        return new TopicConverter();
    }
}
