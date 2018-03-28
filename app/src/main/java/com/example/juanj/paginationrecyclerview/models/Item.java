package com.example.juanj.paginationrecyclerview.models;

import java.io.Serializable;

/**
 * Created by juanj on 27/03/2018.
 */

public class Item implements Serializable{
    private String kind, etag;
    private Snippet snippet;

    public String getKind() {
        return kind;
    }

    public String getEtag() {
        return etag;
    }

    public Snippet getSnippet() {
        return snippet;
    }
}