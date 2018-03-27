package com.example.juanj.paginationrecyclerview.ui.main;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.example.juanj.paginationrecyclerview.data.IVideosRepository;

import javax.inject.Inject;

/**
 * Created by juanj on 27/03/2018.
 */

public class MainViewModelFactory implements ViewModelProvider.Factory {

    private IVideosRepository videosRepository;

    @Inject
    public MainViewModelFactory(IVideosRepository videosRepository) {
        this.videosRepository = videosRepository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if(modelClass.isAssignableFrom(MainViewModel.class))
            return (T) new MainViewModel(videosRepository);
        throw new IllegalArgumentException("Unknown view model class");
    }
}
