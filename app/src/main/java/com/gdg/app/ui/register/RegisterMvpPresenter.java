package com.gdg.app.ui.register;

import com.gdg.app.di.PerActivity;
import com.gdg.app.ui.base.MvpPresenter;

@PerActivity
public interface RegisterMvpPresenter<V extends RegisterMvpView> extends MvpPresenter<V> {

    void onDrawerOptionAboutClick();

    void onDrawerOptionLogoutClick();

    void onDrawerRateUsClick();

    void onDrawerMyFeedClick();

    void onNavMenuCreated();
}
