package com.gdg.app.ui.login;

import com.gdg.app.di.PerActivity;
import com.gdg.app.ui.base.MvpPresenter;

@PerActivity
public interface LoginMvpPresenter<V extends LoginMvpView> extends MvpPresenter<V> {

    void onServerLoginClick(String email, String password);

    void onGoogleLoginClick();

    void onFacebookLoginClick();

}
