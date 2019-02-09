package com.gdg.app;

import android.app.Application;
import android.content.Context;

import com.gdg.app.data.DataManager;
import com.gdg.app.di.component.ApplicationComponent;
import com.gdg.app.di.component.DaggerApplicationComponent;
import com.gdg.app.di.module.ApplicationModule;
import com.gdg.app.utils.AppLogger;

import javax.inject.Inject;

public class MvpApp extends Application {

    public static Context context;

    @Inject
    DataManager mDataManager;

    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();

        mApplicationComponent.inject(this);

        AppLogger.init();

        context = this;
    }

    public static Context getContext() {
        return context;
    }

    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }

    // Needed to replace the component with a test specific one
    public void setComponent(ApplicationComponent applicationComponent) {
        mApplicationComponent = applicationComponent;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        // todo install the MultiDex library in the gradle
//        MultiDex.install(this);
    }
}
