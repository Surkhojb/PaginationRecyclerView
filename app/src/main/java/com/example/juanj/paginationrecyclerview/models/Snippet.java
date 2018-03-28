package com.example.juanj.paginationrecyclerview.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by juanj on 27/03/2018.
 */

public class Snippet implements Serializable {
    private String publishedAt, channelId, title, description, channelTitle, categoryId, liveBroadcastContent;
    private Thumbnails thumbnails;
    private List<String> tags = new ArrayList<>();

    public String getPublishedAt() {
        return publishedAt;
    }

    public String getChannelId() {
        return channelId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getChannelTitle() {
        return channelTitle;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public String getLiveBroadcastContent() {
        return liveBroadcastContent;
    }

    public Thumbnails getThumbnails() {
        return thumbnails;
    }

    public List<String> getTags() {
        return tags;
    }
}