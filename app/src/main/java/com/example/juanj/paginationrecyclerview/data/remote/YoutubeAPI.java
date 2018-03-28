package com.example.juanj.paginationrecyclerview.data.remote;



import com.example.juanj.paginationrecyclerview.data.remote.model.YoutubeResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by juanj on 27/03/2018.
 */

public interface YoutubeAPI {
    @GET("search")
    Observable<YoutubeResponse> searchVideo(@Query("q") String query,
                                            @Query("type") String type,
                                            @Query("key") String key,
                                            @Query("part") String part,
                                            @Query("maxResults") String maxResults,
                                            @Query("pageToken") String pageToken);
}
