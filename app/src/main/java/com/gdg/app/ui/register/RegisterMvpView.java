package com.gdg.app.ui.register;


import com.gdg.app.ui.base.MvpView;

public interface RegisterMvpView extends MvpView {

    void openLoginActivity();

    void updateUserName(String currentUserName);

    void updateUserEmail(String currentUserEmail);

    void updateUserProfilePic(String currentUserProfilePicUrl);

    void updateAppVersion();

    void closeNavigationDrawer();

    void lockDrawer();

    void unlockDrawer();
}
