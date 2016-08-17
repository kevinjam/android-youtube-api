package com.kevinjanvier.youtubeapikevin.content;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by kevinjanvier on 17/08/16.
 */
public class YouTubeContent {
    /*
    we shall have all the videos display here
     */
    /**
     * Inside a list view
     */
    public static List<YouTubeVideo> ITEMS = new ArrayList<>();

    /**
     * Map of youtube Chanel Id
     */

    public static Map<String, YouTubeVideo> ITEM_MAP = new HashMap<>();

    static {
        addItem(new YouTubeVideo("O3rcazNok4M", "마지막 때 부흥과 영광 3차 컨퍼런스 Pastor Denis Kasirye"));
        addItem(new YouTubeVideo("fyyx1qSOdxM", "마지막 때 부흥과 영광 3차 컨퍼런스 Pastor Dennis Kasirye"));
        addItem(new YouTubeVideo("tAYNv92eoqA", "마지막 때 부흥과 영광 2차 컨퍼런스(2013.3.26 오후) Pastor Dennis "));
        addItem(new YouTubeVideo("hZajHbrKuvk", "마지막 때 부흥과 영광 2차 컨퍼런스(2013.3.27 오후) Pastor Dennis Kasirye"));
        addItem(new YouTubeVideo("hZajHbrKuvk", "Afternoon - Dennis Kasirye"));
        addItem(new YouTubeVideo("hZajHbrKuvk", "마지막 때 부흥과 영광 3차 컨퍼런스 by Dennis Kasirye"));
        addItem(new YouTubeVideo("fyyx1qSOdxM", "마지막 때 부흥과 영광 2차 컨퍼런스(2013.3.26 오후) Pastor Dennis Kasirye"));
        addItem(new YouTubeVideo("O3rcazNok4M", "마지막 때 부흥과 영광 2차 컨퍼런스 - Dennis Kasirye"));
        addItem(new YouTubeVideo("O3rcazNok4M", "마지막 때 부흥과 영광 3차 컨퍼런스"));
    }
    private static void addItem(final YouTubeVideo item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    /**
     * A POJO representing a YouTube video
     */
    public static class YouTubeVideo {
        public String id;
        public String title;

        public YouTubeVideo(String id, String content) {
            this.id = id;
            this.title = content;
        }

        @Override
        public String toString() {
            return title;
        }
    }
}
