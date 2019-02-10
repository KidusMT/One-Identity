package com.gdg.app.data.network;

import com.androidnetworking.interceptors.HttpLoggingInterceptor;
import com.gdg.app.BuildConfig;
import com.gdg.app.data.db.model.person.PersonResponse;
import com.gdg.app.data.network.model.LoginRequest;
import com.gdg.app.data.network.model.LoginResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by KidusMT.
 */

public interface ApiCall {

    String HEADER_PARAM_SEPARATOR = ":";

    @GET(ApiEndPoint.PERSONS)
    @Headers(ApiHeader.API_AUTH_TYPE + HEADER_PARAM_SEPARATOR + ApiHeader.PROTECTED_API)
    Observable<PersonResponse> getPersons();

    @POST(ApiEndPoint.LOGIN)
    @Headers(ApiHeader.API_AUTH_TYPE + HEADER_PARAM_SEPARATOR + ApiHeader.PUBLIC_API)
    Observable<LoginResponse> login(@Body LoginRequest.ServerLoginRequest request);

    class Factory {

        private static final int NETWORK_CALL_TIMEOUT = 60;
        public static Retrofit retrofit;

        public static ApiCall create(ApiInterceptor apiInterceptor) {

            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.addInterceptor(apiInterceptor);
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);
            builder.addInterceptor(logging);
            builder.readTimeout(NETWORK_CALL_TIMEOUT, TimeUnit.SECONDS);
            builder.writeTimeout(NETWORK_CALL_TIMEOUT, TimeUnit.SECONDS);

            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();

            OkHttpClient httpClient = builder.build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(BuildConfig.BASE_URL)
                    .client(httpClient)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();

            return retrofit.create(ApiCall.class);

        }

        public static Retrofit retrofit() {
            return retrofit;
        }
    }
}
