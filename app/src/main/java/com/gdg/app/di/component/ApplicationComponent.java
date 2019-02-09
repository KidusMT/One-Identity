package com.gdg.app.di.component;

import android.app.Application;
import android.content.Context;

import com.gdg.app.MvpApp;
import com.gdg.app.data.DataManager;
import com.gdg.app.di.ApplicationContext;
import com.gdg.app.di.module.ApplicationModule;
import com.gdg.app.service.SyncService;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(MvpApp app);

    void inject(SyncService service);

    @ApplicationContext
    Context context();

    Application application();

    DataManager getDataManager();
}