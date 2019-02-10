package com.gdg.app.data.network;

import com.gdg.app.data.db.model.person.PersonResponse;
import com.gdg.app.data.network.model.LoginRequest;
import com.gdg.app.data.network.model.LoginResponse;
import com.gdg.app.data.network.model.LogoutResponse;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

@Singleton
public class AppApiHelper implements ApiHelper {

    private ApiHeader mApiHeader;
    private ApiCall mApiCall;

    @Inject
    public AppApiHelper(ApiHeader apiHeader, ApiCall apiCall) {
        mApiHeader = apiHeader;
        mApiCall = apiCall;
    }

    @Override
    public ApiHeader getApiHeader() {
        return mApiHeader;
    }

    @Override
    public void setApiHeader(ApiHeader apiHeader) {
        if (apiHeader != null) {
//            mApiHeader.setApiKey(apiHeader.getApiKey());
//            mApiHeader.setUserId(apiHeader.getUserId());
            mApiHeader.setAccessToken(apiHeader.getAccessToken());
        }
    }

    @Override
    public Observable<PersonResponse> getPersons() {
        return mApiCall.getPersons();
    }

    @Override
    public Observable<LoginResponse> doServerLoginApiCall(LoginRequest.ServerLoginRequest request) {
        return mApiCall.login(request);
    }

    @Override
    public Observable<LogoutResponse> doLogoutApiCall() {
        return null;
    }


}

