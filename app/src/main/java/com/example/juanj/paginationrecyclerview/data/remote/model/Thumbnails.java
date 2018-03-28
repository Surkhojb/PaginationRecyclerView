package com.example.juanj.paginationrecyclerview.data.remote.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by juanj on 27/03/2018.
 */

public  class Thumbnails implements Serializable {
    @SerializedName("default")
    private Default _default;

    @SerializedName("medium")
    private Default medium;

    @SerializedName("high")
    private Default high;

    public Default getDefault() {
        return _default;
    }

    public Default getMedium() {
        return medium;
    }

    public void setMedium(Default medium) {
        this.medium = medium;
    }

    public Default getHigh() {
        return high;
    }

    public void setHigh(Default high) {
        this.high = high;
    }

    public static final class Default implements Serializable{
        private String url;
        private int width, height;

        public String getUrl() {
            return url;
        }

        public int getWidth() {
            return width;
        }

        public int getHeight() {
            return height;
        }
    }

    @Override
    public String toString() {
        return "Thumbnails{" +
                "_default=" + _default +
                ", medium=" + medium +
                ", high=" + high +
                '}';
    }
}