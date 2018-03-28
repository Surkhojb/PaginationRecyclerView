package com.example.juanj.paginationrecyclerview.models;

import java.io.Serializable;

/**
 * Created by juanj on 28/03/2018.
 */

public class Video implements Serializable{
    private String videoId;
    private String title;
    private String description;
    private String thumbnailHigh;
    private String publishedAt;

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumbnailHigh() {
        return thumbnailHigh;
    }

    public void setThumbnailHigh(String thumbnailHigh) {
        this.thumbnailHigh = thumbnailHigh;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    @Override
    public String toString() {
        return "Video{" +
                "videoId='" + videoId + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", thumbnailHigh='" + thumbnailHigh + '\'' +
                ", publishedAt='" + publishedAt + '\'' +
                '}';
    }
}
