package com.example.juanj.paginationrecyclerview.data;

import com.example.juanj.paginationrecyclerview.data.remote.model.YoutubeResponse;

import io.reactivex.Observable;

/**
 * Created by juanj on 27/03/2018.
 */

public interface IVideosRepository {
    Observable<YoutubeResponse> getVideos(String tokenPage);
}
