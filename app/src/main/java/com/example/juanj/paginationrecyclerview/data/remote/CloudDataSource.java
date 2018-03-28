package com.example.juanj.paginationrecyclerview.data.remote;

import com.example.juanj.paginationrecyclerview.BuildConfig;
import com.example.juanj.paginationrecyclerview.data.remote.model.YoutubeResponse;

import javax.inject.Inject;

import dagger.Lazy;
import io.reactivex.Observable;

/**
 * Created by juanj on 27/03/2018.
 */

public class CloudDataSource implements ICloudDataSource{
    private final String API_KEY = BuildConfig.API_KEY;
    private final String YOUTUBE_API_TYPE = "video";
    private final String YOUTUBE_API_PART = "snippet";
    private final String YOUTUBE_API_MAX_RESULT_PAGE = "10";
    private final String YOUTUBE_QUERY_ALL_VIDEOS = "android development";

    @Inject
    Lazy<YoutubeAPI> youtubeApi;

    @Inject
    public CloudDataSource(){}
    @Override
    public Observable<YoutubeResponse> getVideos(String pageToken) {
        return youtubeApi.get().searchVideo(YOUTUBE_QUERY_ALL_VIDEOS,YOUTUBE_API_TYPE,
                API_KEY,YOUTUBE_API_PART,YOUTUBE_API_MAX_RESULT_PAGE,pageToken);
    }
}
