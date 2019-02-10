package com.gdg.app.ui.main;

import com.gdg.app.ui.base.MvpView;

public interface MainMvpView extends MvpView {

    void openLoginActivity();

    void updateUserName(String currentUserName);

    void updateUserEmail(String currentUserEmail);

    void updateUserProfilePic(String currentUserProfilePicUrl);

    void closeNavigationDrawer();

    void lockDrawer();

    void unlockDrawer();
}
