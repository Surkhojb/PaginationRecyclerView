package com.example.juanj.paginationrecyclerview.data;

import com.example.juanj.paginationrecyclerview.data.remote.CloudDataSource;
import com.example.juanj.paginationrecyclerview.data.remote.model.YoutubeResponse;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by juanj on 27/03/2018.
 */

public class VideosRepository implements IVideosRepository {

    @Inject
    CloudDataSource cloudDataSource;

    @Inject
    public VideosRepository(){}

    @Override
    public Observable<YoutubeResponse> getVideos(String tokenPage) {
        return cloudDataSource.getVideos(tokenPage);
    }
}
