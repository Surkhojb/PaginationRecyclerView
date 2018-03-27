package com.example.juanj.paginationrecyclerview.data.remote;

import com.example.juanj.paginationrecyclerview.models.YoutubeResponse;

import io.reactivex.Observable;


/**
 * Created by juanj on 27/03/2018.
 */

public interface ICloudDataSource {
    Observable<YoutubeResponse> getVideos(String pageToken);
}
