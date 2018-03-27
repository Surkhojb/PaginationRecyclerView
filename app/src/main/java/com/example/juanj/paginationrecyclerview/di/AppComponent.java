package com.example.juanj.paginationrecyclerview.di;

import com.example.juanj.paginationrecyclerview.di.modules.AppModule;
import com.example.juanj.paginationrecyclerview.di.modules.CloudModule;
import com.example.juanj.paginationrecyclerview.ui.main.MainActivity;
import com.example.juanj.paginationrecyclerview.MyApplication;
import com.example.juanj.paginationrecyclerview.data.IVideosRepository;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by juanj on 27/03/2018.
 */
@Singleton
@Component(modules = {AppModule.class,CloudModule.class})
public interface AppComponent {
    void inject(MyApplication application);

    IVideosRepository repository();
}
