package com.example.juanj.paginationrecyclerview.data.remote.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by juanj on 27/03/2018.
 */

public final class YoutubeResponse implements Serializable {
    private String kind, etag, nextPageToken;
    private PageInfo pageInfo;
    private List<Item> items = new ArrayList<>();

    public String getKind() {
        return kind;
    }

    public String getEtag() {
        return etag;
    }

    public String getNextPageToken() {
        return nextPageToken;
    }

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public List<Item> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "YoutubeResponse{" +
                "kind='" + kind + '\'' +
                ", etag='" + etag + '\'' +
                ", nextPageToken='" + nextPageToken + '\'' +
                ", pageInfo=" + pageInfo +
                ", items=" + items +
                '}';
    }
}
