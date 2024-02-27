package com.example.spokbit.validator;

import com.example.spokbit.entitys.Video;
import com.example.spokbit.exception.exceptionVideo.IncorrectVideoRequestException;
import com.example.spokbit.util.ExceptionVideoMessagesEnum;
import java.util.Objects;

public final class VideoValidator {
    public static void valideteThis(Video video) {
        if (Objects.equals(video.getUrl(), null)) {
            throw new IncorrectVideoRequestException(ExceptionVideoMessagesEnum.INCORRECT_REQUEST_NULL_URL.getMessage());
        }

        if (Objects.equals(video.getUrl(), "")) {
            throw new IncorrectVideoRequestException(ExceptionVideoMessagesEnum.INCORRECT_REQUEST_EMPTY_URL.getMessage());
        }
    }
}
