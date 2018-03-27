package com.example.juanj.paginationrecyclerview;

import android.app.Application;

import com.example.juanj.paginationrecyclerview.di.AppComponent;
import com.example.juanj.paginationrecyclerview.di.modules.AppModule;
import com.example.juanj.paginationrecyclerview.di.modules.CloudModule;
import com.example.juanj.paginationrecyclerview.di.DaggerAppComponent;

/**
 * Created by juanj on 27/03/2018.
 */

public class MyApplication extends Application {
    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule())
                .cloudModule(new CloudModule())
                .build();

        appComponent.inject(this);
    }

    public static AppComponent getComponent(){
        return appComponent;
    }
}
