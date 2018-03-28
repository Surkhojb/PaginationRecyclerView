package com.example.juanj.paginationrecyclerview.di.modules;

import com.example.juanj.paginationrecyclerview.data.IVideosRepository;
import com.example.juanj.paginationrecyclerview.di.scopes.PerActivity;
import com.example.juanj.paginationrecyclerview.models.VideoTransformer;
import com.example.juanj.paginationrecyclerview.ui.main.MainViewModelFactory;

import dagger.Module;
import dagger.Provides;

/**
 * Created by juanj on 27/03/2018.
 */

@Module
public class MainModule {

    public MainModule() {
    }

    @PerActivity
    @Provides
    MainViewModelFactory providesFactory(IVideosRepository videosRepository, VideoTransformer transformer){
        return new MainViewModelFactory(videosRepository,transformer);
    }

}
