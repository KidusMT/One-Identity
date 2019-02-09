package com.gdg.app.di.module;

import android.app.Application;
import android.content.Context;

import com.gdg.app.BuildConfig;
import com.gdg.app.data.AppDataManager;
import com.gdg.app.data.DataManager;
import com.gdg.app.data.db.AppDbHelper;
import com.gdg.app.data.db.DbHelper;
import com.gdg.app.data.network.ApiCall;
import com.gdg.app.data.network.ApiHeader;
import com.gdg.app.data.network.ApiHelper;
import com.gdg.app.data.network.ApiInterceptor;
import com.gdg.app.data.network.AppApiHelper;
import com.gdg.app.data.prefs.AppPreferencesHelper;
import com.gdg.app.data.prefs.PreferencesHelper;
import com.gdg.app.utils.AppConstants;
import com.gdg.app.di.ApiInfo;
import com.gdg.app.di.ApplicationContext;
import com.gdg.app.di.DatabaseInfo;
import com.gdg.app.di.PreferenceInfo;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return AppConstants.DB_NAME;
    }

    @Provides
    @ApiInfo
    String provideApiKey() {
        return BuildConfig.API_KEY;
    }

    @Provides
    @PreferenceInfo
    String providePreferenceName() {
        return AppConstants.PREF_NAME;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

    @Provides
    @Singleton
    DbHelper provideDbHelper(AppDbHelper appDbHelper) {
        return appDbHelper;
    }

    @Provides
    @Singleton
    ApiHelper provideApiHelper(AppApiHelper appApiHelper) {
        return appApiHelper;
    }

    @Provides
    @Singleton
    ApiCall provideApiCall(ApiInterceptor apiInterceptor) {
        return ApiCall.Factory.create(apiInterceptor);
    }

    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(AppPreferencesHelper appPreferencesHelper) {
        return appPreferencesHelper;
    }

    @Provides
    @Singleton
    ApiHeader provideApiHeader(PreferencesHelper preferencesHelper) {
        return new ApiHeader(preferencesHelper.getAccessToken());
    }

}
