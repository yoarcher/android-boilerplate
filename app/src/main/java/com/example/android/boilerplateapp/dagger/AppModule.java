package com.example.android.boilerplateapp.dagger;

import android.app.Application;
import android.content.Context;

import org.greenrobot.eventbus.EventBus;

import dagger.Module;
import dagger.Provides;

/**
 * Created by yuanyou.
 */
@Module
public class AppModule {
    private final Application application;

    public AppModule(final Application application) {
        this.application = application;
    }

    @Provides
    public Context providesContext() {
        return application;
    }

    @Provides
    public EventBus providesEventBus() {
        return EventBus.getDefault();
    }
}
