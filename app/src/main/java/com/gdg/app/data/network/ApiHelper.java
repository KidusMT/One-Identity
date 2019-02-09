package com.gdg.app.data.network;

import com.gdg.app.data.network.model.LoginRequest;
import com.gdg.app.data.network.model.LoginResponse;
import com.gdg.app.data.network.model.LogoutResponse;

import io.reactivex.Observable;

public interface ApiHelper {

    ApiHeader getApiHeader();

    void setApiHeader(ApiHeader apiHeader);

//    Observable<LoginResponse> doGoogleLoginApiCall(LoginRequest.GoogleLoginRequest request);
//
//    Observable<LoginResponse> doFacebookLoginApiCall(LoginRequest.FacebookLoginRequest request);

    Observable<LoginResponse> doServerLoginApiCall(LoginRequest.ServerLoginRequest request);

    Observable<LogoutResponse> doLogoutApiCall();
}
