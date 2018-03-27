package com.example.juanj.paginationrecyclerview.ui.main;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.juanj.paginationrecyclerview.data.IVideosRepository;
import com.example.juanj.paginationrecyclerview.models.Item;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by juanj on 27/03/2018.
 */

public class MainViewModel extends ViewModel {
    private String loadMoreToken = "";
    private MutableLiveData<List<Item>> listVideos = new MutableLiveData<>();
    private IVideosRepository videosRepository;

    public MainViewModel(IVideosRepository videosRepository) {
        this.videosRepository = videosRepository;
    }

    public LiveData<List<Item>> listVideos(){
        return listVideos;
    }

    public void search(boolean loadMore){
        if(!loadMore)
            loadMoreToken = "";

        videosRepository.getVideos(loadMoreToken).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(youtubeResponse -> {
                    listVideos.setValue(youtubeResponse.getItems());
                    loadMoreToken = youtubeResponse.getNextPageToken();
                    System.out.println("NEXT TOKEN: " + loadMoreToken);
                });
    }
}
