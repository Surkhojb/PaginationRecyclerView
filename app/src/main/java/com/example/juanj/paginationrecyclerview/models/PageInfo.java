package com.example.juanj.paginationrecyclerview.models;

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
}