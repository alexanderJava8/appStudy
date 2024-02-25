package com.example.spokbit.converter;

import com.example.spokbit.dto.VideoDto;
import com.example.spokbit.entitys.Video;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class VideoConverter {
    private final ModelMapper modelMapper;

    public VideoConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public VideoDto videoEntityToVideoDto(Video video) {
        return modelMapper.map(video, VideoDto.class);
    }

    public Video videoDtoToVideoEntity(VideoDto videoDto) {
        return modelMapper.map(videoDto, Video.class);
    }
}
