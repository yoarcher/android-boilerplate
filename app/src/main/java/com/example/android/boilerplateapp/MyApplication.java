package com.example.android.boilerplateapp;

import android.app.Application;

import com.example.android.boilerplateapp.dagger.AppComponent;
import com.example.android.boilerplateapp.dagger.AppModule;
import com.example.android.boilerplateapp.dagger.DaggerAppComponent;
import com.example.android.boilerplateapp.data.remote.GithubService;

import javax.inject.Inject;

/**
 * Created by yuanyou.
 */

public class MyApplication extends Application {
    private AppComponent appComponent;

    private static MyApplication application;

    public static MyApplication getApplication() {
        return application;
    }

    @Inject
    GithubService githubService;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
        appComponent.inject(this);
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
