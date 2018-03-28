package com.example.juanj.paginationrecyclerview.data.remote.model;

import java.io.Serializable;

/**
 * Created by juanj on 27/03/2018.
 */

public class Item implements Serializable{
    private String kind, etag;
    private Id id;
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

    public Id getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Item{" +
                "kind='" + kind + '\'' +
                ", etag='" + etag + '\'' +
                ", id=" + id +
                ", snippet=" + snippet +
                '}';
    }
}