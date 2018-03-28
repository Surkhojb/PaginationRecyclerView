package com.example.juanj.paginationrecyclerview.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by juanj on 27/03/2018.
 */

public  class Thumbnails implements Serializable {
    @SerializedName("default")
    private Default _default;

    public Default getDefault() {
        return _default;
    }

    public static final class Default {
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
}