package com.example.juanj.paginationrecyclerview.di.modules;

import com.example.juanj.paginationrecyclerview.data.remote.YoutubeAPI;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by juanj on 27/03/2018.
 */

@Module
public class CloudModule {
   private final String BASE_URL = "https://www.googleapis.com/youtube/v3/";

    public CloudModule() {
    }


    @Singleton
    @Provides
    OkHttpClient providesClient(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder().addInterceptor(interceptor).build();
    }

    @Singleton
    @Provides
    Gson providesGson(){
        return new GsonBuilder().create();
    }

    @Provides
    @Singleton
    Retrofit providesRetrofit(Gson gson,OkHttpClient client){
        return new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .baseUrl(BASE_URL)
                .build();
    }

    @Singleton
    @Provides
    YoutubeAPI providesYoutubeApi(Retrofit retrofit){
        return retrofit.create(YoutubeAPI.class);
    }


}
