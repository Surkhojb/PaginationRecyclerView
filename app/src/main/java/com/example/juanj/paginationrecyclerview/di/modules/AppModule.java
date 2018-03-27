package com.example.juanj.paginationrecyclerview.di.modules;

import com.example.juanj.paginationrecyclerview.data.remote.CloudDataSource;
import com.example.juanj.paginationrecyclerview.data.remote.ICloudDataSource;
import com.example.juanj.paginationrecyclerview.data.IVideosRepository;
import com.example.juanj.paginationrecyclerview.data.VideosRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by juanj on 27/03/2018.
 */

@Module
public class AppModule {

    public AppModule() {
    }

    @Provides
    @Singleton
    ICloudDataSource providesCloudDataSource(CloudDataSource cloudDataSource){
        return cloudDataSource;
    }

    @Provides
    @Singleton
    IVideosRepository providesRepository(VideosRepository videosRepository){
        return videosRepository;
    }
}
