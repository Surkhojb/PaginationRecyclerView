package com.example.juanj.paginationrecyclerview.data.remote.model;

import java.io.Serializable;

/**
 * Created by juanj on 27/03/2018.
 */

public class PageInfo implements Serializable{
    private int totalResults, resultsPerPage;

    public int getTotalResults() {
        return totalResults;
    }

    public int getResultsPerPage() {
        return resultsPerPage;
    }

    @Override
    public String toString() {
        return "PageInfo{" +
                "totalResults=" + totalResults +
                ", resultsPerPage=" + resultsPerPage +
                '}';
    }
}