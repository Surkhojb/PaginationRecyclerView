package com.example.juanj.paginationrecyclerview.ui.main;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.juanj.paginationrecyclerview.data.IVideosRepository;
import com.example.juanj.paginationrecyclerview.models.Video;
import com.example.juanj.paginationrecyclerview.models.VideoTransformer;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by juanj on 27/03/2018.
 */

public class MainViewModel extends ViewModel {
    private String loadMoreToken = "";
    private MutableLiveData<List<Video>> listVideos = new MutableLiveData<>();
    private IVideosRepository videosRepository;
    private VideoTransformer videoTransformer;

    public MainViewModel(IVideosRepository videosRepository, VideoTransformer transformer) {
        this.videosRepository = videosRepository;
        this.videoTransformer = transformer;
    }

    public LiveData<List<Video>> listVideos(){
        return listVideos;
    }

    public void search(boolean loadMore){
        if(!loadMore)
            loadMoreToken = "";

        videosRepository.getVideos(loadMoreToken).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> {listVideos.postValue(videoTransformer.transform(response));

                    loadMoreToken = response.getNextPageToken();
                });
    }
}
