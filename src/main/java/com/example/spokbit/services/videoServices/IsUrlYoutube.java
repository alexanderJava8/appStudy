package com.example.spokbit.services.videoServices;

import com.example.spokbit.exception.exceptionVideo.URLNotFromYoutubeException;
import com.example.spokbit.util.ExceptionVideoMessagesEnum;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

public class IsUrlYoutube {
    public static boolean isURLYoutube(String url) {
        try {
            URL urlObjt = new URL(url);
            String host = urlObjt.getHost();
            if (Objects.equals(host, "www.youtube.com")) {
                return host.endsWith("youtube.com");
            } else {
                throw new URLNotFromYoutubeException(ExceptionVideoMessagesEnum.INCORRECT_REQUEST_URL_NOT_FROM_YOUTUBE.getMessage());
            }
        } catch (URLNotFromYoutubeException e) {
            throw new URLNotFromYoutubeException(ExceptionVideoMessagesEnum.INCORRECT_REQUEST_URL_NOT_FROM_YOUTUBE.getMessage());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
