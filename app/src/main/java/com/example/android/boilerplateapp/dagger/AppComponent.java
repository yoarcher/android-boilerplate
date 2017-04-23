package com.example.android.boilerplateapp.dagger;

import com.example.android.boilerplateapp.MyApplication;
import com.example.android.boilerplateapp.data.remote.GithubModule;
import com.example.android.boilerplateapp.ui.main.MainFragViewModel;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by yuanyou.
 */
@Singleton
@Component(modules = {
        AppModule.class,
        GithubModule.class
})
public interface AppComponent {

    void inject(MyApplication application);

    void inject(MainFragViewModel mainFragViewModel);
}
