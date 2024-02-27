package com.example.spokbit.services.videoServices;

import java.net.URL;

public final class URLModifier {
    public static String modifyUrl(String url) {

        int index = url.indexOf("watch?v=");

        if (index != -1) {
            String videoId = url.substring(index + 8);
            return "https://www.youtube.com/embed/" + videoId;
        } else {
            return "Mal URL";
        }
    }
}
