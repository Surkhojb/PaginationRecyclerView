package com.example.juanj.paginationrecyclerview.data.remote.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by juanj on 28/03/2018.
 */
public class Id {
    @SerializedName("kind")
    public String kind;
    @SerializedName("videoId")
    public String videoId;

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }
}
