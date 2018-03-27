package com.example.juanj.paginationrecyclerview.di;

import com.example.juanj.paginationrecyclerview.di.modules.MainModule;
import com.example.juanj.paginationrecyclerview.di.scopes.PerActivity;
import com.example.juanj.paginationrecyclerview.ui.main.MainActivity;

import dagger.Component;

/**
 * Created by juanj on 27/03/2018.
 */

@PerActivity
@Component(dependencies = AppComponent.class,modules = MainModule.class)
public interface MainComponent {
    void inject(MainActivity mainActivity);
}
