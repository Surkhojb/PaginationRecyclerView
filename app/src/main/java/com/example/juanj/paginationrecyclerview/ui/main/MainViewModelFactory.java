package com.example.juanj.paginationrecyclerview.ui.main;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.example.juanj.paginationrecyclerview.data.IVideosRepository;
import com.example.juanj.paginationrecyclerview.models.VideoTransformer;

import javax.inject.Inject;

/**
 * Created by juanj on 27/03/2018.
 */

public class MainViewModelFactory implements ViewModelProvider.Factory {

    private IVideosRepository videosRepository;
    private VideoTransformer videoTransformer;

    @Inject
    public MainViewModelFactory(IVideosRepository videosRepository,VideoTransformer transformer) {
        this.videosRepository = videosRepository;
        this.videoTransformer = transformer;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if(modelClass.isAssignableFrom(MainViewModel.class))
            return (T) new MainViewModel(videosRepository,videoTransformer);
        throw new IllegalArgumentException("Unknown view model class");
    }
}
