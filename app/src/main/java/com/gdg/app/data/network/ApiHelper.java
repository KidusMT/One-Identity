package com.gdg.app.data.network;

import com.gdg.app.data.db.model.person.PersonResponse;
import com.gdg.app.data.network.model.LoginRequest;
import com.gdg.app.data.network.model.LoginResponse;
import com.gdg.app.data.network.model.LogoutResponse;

import io.reactivex.Observable;

public interface ApiHelper {

    ApiHeader getApiHeader();

    void setApiHeader(ApiHeader apiHeader);

    Observable<PersonResponse> getPersons();

    Observable<LoginResponse> doServerLoginApiCall(LoginRequest.ServerLoginRequest request);

    Observable<LogoutResponse> doLogoutApiCall();
}
