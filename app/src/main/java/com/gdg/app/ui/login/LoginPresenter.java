package com.gdg.app.ui.login;


import com.gdg.app.R;
import com.gdg.app.data.DataManager;
import com.gdg.app.data.network.model.LoginRequest;
import com.gdg.app.ui.base.BasePresenter;
import com.gdg.app.utils.CommonUtils;
import com.gdg.app.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class LoginPresenter<V extends LoginMvpView> extends BasePresenter<V>
        implements LoginMvpPresenter<V> {

    private static final String TAG = "LoginPresenter";

    @Inject
    public LoginPresenter(DataManager dataManager,
                          SchedulerProvider schedulerProvider,
                          CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onServerLoginClick(String email, String password) {
        //validate email and password
        if (email == null || email.isEmpty()) {
            getMvpView().onError(R.string.empty_email);
            return;
        }

//        if (!CommonUtils.isEmailValid(email)) {
//            getMvpView().onError(R.string.invalid_email);
//            return;
//        }

        if (password == null || password.isEmpty()) {
            getMvpView().onError(R.string.empty_password);
            return;
        }
        getMvpView().showLoading();

        getCompositeDisposable().add(getDataManager()
                .doServerLoginApiCall(new LoginRequest.ServerLoginRequest(email, password))
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(userResponse -> {
                    getDataManager().updateUserInfo(
                            userResponse.getToken(),
                            userResponse.getUser().getId(),
                            DataManager.LoggedInMode.LOGGED_IN_MODE_SERVER,
                            userResponse.getUser().getFname() + " " +
                                    userResponse.getUser().getMname() + " " +
                                    userResponse.getUser().getLname(),
                            userResponse.getUser().getEmail()//,
//                            response.getGoogleProfilePicUrl()
                    );

                    if (!isViewAttached()) {
                        return;
                    }

                    getMvpView().hideLoading();
                    getMvpView().openMainActivity();

                }, throwable -> {

                    if (!isViewAttached()) {
                        return;
                    }

                    getMvpView().hideLoading();
                    getMvpView().onError(CommonUtils.getErrorMessage(throwable));

                }));
    }

    @Override
    public void onAttach(V mvpView) {
        super.onAttach(mvpView);
        decideNextActivity();
    }

    private void decideNextActivity() {
        // todo updated later - if found better implementation
        if (getDataManager().getCurrentUserLoggedInMode()
                == DataManager.LoggedInMode.LOGGED_IN_MODE_SERVER.getType()) {
//            getMvpView().open();
//        } else {
            getMvpView().openMainActivity();
        }
    }
}
