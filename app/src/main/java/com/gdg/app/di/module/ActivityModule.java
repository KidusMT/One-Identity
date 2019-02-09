package com.gdg.app.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.gdg.app.di.ActivityContext;
import com.gdg.app.di.PerActivity;
import com.gdg.app.ui.login.LoginMvpPresenter;
import com.gdg.app.ui.login.LoginMvpView;
import com.gdg.app.ui.login.LoginPresenter;
import com.gdg.app.ui.main.MainMvpPresenter;
import com.gdg.app.ui.main.MainMvpView;
import com.gdg.app.ui.main.MainPresenter;
import com.gdg.app.ui.main.PersonAdapter;
import com.gdg.app.utils.rx.AppSchedulerProvider;
import com.gdg.app.utils.rx.SchedulerProvider;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

@Module
public class ActivityModule {

    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return mActivity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }

    @Provides
    @PerActivity
    LoginMvpPresenter<LoginMvpView> provideLoginPresenter(
            LoginPresenter<LoginMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    MainMvpPresenter<MainMvpView> provideMainPresenter(
            MainPresenter<MainMvpView> presenter) {
        return presenter;
    }


    @Provides
    PersonAdapter providePostAdapter() {
        return new PersonAdapter(new ArrayList<>());
    }

    @Provides
    LinearLayoutManager provideLinearLayoutManager(AppCompatActivity activity) {
        return new LinearLayoutManager(activity);
    }
}
