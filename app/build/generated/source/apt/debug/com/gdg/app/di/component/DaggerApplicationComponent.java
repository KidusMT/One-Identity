package com.gdg.app.di.component;

import android.app.Application;
import android.content.Context;
import com.gdg.app.MvpApp;
import com.gdg.app.MvpApp_MembersInjector;
import com.gdg.app.data.AppDataManager;
import com.gdg.app.data.AppDataManager_Factory;
import com.gdg.app.data.DataManager;
import com.gdg.app.data.db.AppDbHelper;
import com.gdg.app.data.db.AppDbHelper_Factory;
import com.gdg.app.data.db.DbHelper;
import com.gdg.app.data.db.DbOpenHelper;
import com.gdg.app.data.db.DbOpenHelper_Factory;
import com.gdg.app.data.network.ApiCall;
import com.gdg.app.data.network.ApiHeader;
import com.gdg.app.data.network.ApiHelper;
import com.gdg.app.data.network.ApiInterceptor;
import com.gdg.app.data.network.ApiInterceptor_Factory;
import com.gdg.app.data.network.AppApiHelper;
import com.gdg.app.data.network.AppApiHelper_Factory;
import com.gdg.app.data.prefs.AppPreferencesHelper;
import com.gdg.app.data.prefs.AppPreferencesHelper_Factory;
import com.gdg.app.data.prefs.PreferencesHelper;
import com.gdg.app.di.module.ApplicationModule;
import com.gdg.app.di.module.ApplicationModule_ProvideApiCallFactory;
import com.gdg.app.di.module.ApplicationModule_ProvideApiHeaderFactory;
import com.gdg.app.di.module.ApplicationModule_ProvideApiHelperFactory;
import com.gdg.app.di.module.ApplicationModule_ProvideApplicationFactory;
import com.gdg.app.di.module.ApplicationModule_ProvideContextFactory;
import com.gdg.app.di.module.ApplicationModule_ProvideDataManagerFactory;
import com.gdg.app.di.module.ApplicationModule_ProvideDatabaseNameFactory;
import com.gdg.app.di.module.ApplicationModule_ProvideDbHelperFactory;
import com.gdg.app.di.module.ApplicationModule_ProvidePreferenceNameFactory;
import com.gdg.app.di.module.ApplicationModule_ProvidePreferencesHelperFactory;
import com.gdg.app.service.SyncService;
import com.gdg.app.service.SyncService_MembersInjector;
import dagger.MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.MembersInjectors;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerApplicationComponent implements ApplicationComponent {
  private Provider<Context> provideContextProvider;

  private Provider<String> provideDatabaseNameProvider;

  private Provider<DbOpenHelper> dbOpenHelperProvider;

  private Provider<AppDbHelper> appDbHelperProvider;

  private Provider<DbHelper> provideDbHelperProvider;

  private Provider<String> providePreferenceNameProvider;

  private Provider<AppPreferencesHelper> appPreferencesHelperProvider;

  private Provider<PreferencesHelper> providePreferencesHelperProvider;

  private Provider<ApiHeader> provideApiHeaderProvider;

  private Provider<ApiInterceptor> apiInterceptorProvider;

  private Provider<ApiCall> provideApiCallProvider;

  private Provider<AppApiHelper> appApiHelperProvider;

  private Provider<ApiHelper> provideApiHelperProvider;

  private Provider<AppDataManager> appDataManagerProvider;

  private Provider<DataManager> provideDataManagerProvider;

  private MembersInjector<MvpApp> mvpAppMembersInjector;

  private MembersInjector<SyncService> syncServiceMembersInjector;

  private Provider<Application> provideApplicationProvider;

  private DaggerApplicationComponent(Builder builder) {
    assert builder != null;
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {

    this.provideContextProvider =
        ApplicationModule_ProvideContextFactory.create(builder.applicationModule);

    this.provideDatabaseNameProvider =
        ApplicationModule_ProvideDatabaseNameFactory.create(builder.applicationModule);

    this.dbOpenHelperProvider =
        DoubleCheck.provider(
            DbOpenHelper_Factory.create(
                MembersInjectors.<DbOpenHelper>noOp(),
                provideContextProvider,
                provideDatabaseNameProvider));

    this.appDbHelperProvider =
        DoubleCheck.provider(AppDbHelper_Factory.create(dbOpenHelperProvider));

    this.provideDbHelperProvider =
        DoubleCheck.provider(
            ApplicationModule_ProvideDbHelperFactory.create(
                builder.applicationModule, appDbHelperProvider));

    this.providePreferenceNameProvider =
        ApplicationModule_ProvidePreferenceNameFactory.create(builder.applicationModule);

    this.appPreferencesHelperProvider =
        DoubleCheck.provider(
            AppPreferencesHelper_Factory.create(
                provideContextProvider, providePreferenceNameProvider));

    this.providePreferencesHelperProvider =
        DoubleCheck.provider(
            ApplicationModule_ProvidePreferencesHelperFactory.create(
                builder.applicationModule, appPreferencesHelperProvider));

    this.provideApiHeaderProvider =
        DoubleCheck.provider(
            ApplicationModule_ProvideApiHeaderFactory.create(
                builder.applicationModule, providePreferencesHelperProvider));

    this.apiInterceptorProvider =
        DoubleCheck.provider(ApiInterceptor_Factory.create(provideApiHeaderProvider));

    this.provideApiCallProvider =
        DoubleCheck.provider(
            ApplicationModule_ProvideApiCallFactory.create(
                builder.applicationModule, apiInterceptorProvider));

    this.appApiHelperProvider =
        DoubleCheck.provider(
            AppApiHelper_Factory.create(provideApiHeaderProvider, provideApiCallProvider));

    this.provideApiHelperProvider =
        DoubleCheck.provider(
            ApplicationModule_ProvideApiHelperFactory.create(
                builder.applicationModule, appApiHelperProvider));

    this.appDataManagerProvider =
        DoubleCheck.provider(
            AppDataManager_Factory.create(
                provideDbHelperProvider,
                providePreferencesHelperProvider,
                provideApiHelperProvider));

    this.provideDataManagerProvider =
        DoubleCheck.provider(
            ApplicationModule_ProvideDataManagerFactory.create(
                builder.applicationModule, appDataManagerProvider));

    this.mvpAppMembersInjector = MvpApp_MembersInjector.create(provideDataManagerProvider);

    this.syncServiceMembersInjector =
        SyncService_MembersInjector.create(provideDataManagerProvider);

    this.provideApplicationProvider =
        ApplicationModule_ProvideApplicationFactory.create(builder.applicationModule);
  }

  @Override
  public void inject(MvpApp app) {
    mvpAppMembersInjector.injectMembers(app);
  }

  @Override
  public void inject(SyncService service) {
    syncServiceMembersInjector.injectMembers(service);
  }

  @Override
  public Context context() {
    return provideContextProvider.get();
  }

  @Override
  public Application application() {
    return provideApplicationProvider.get();
  }

  @Override
  public DataManager getDataManager() {
    return provideDataManagerProvider.get();
  }

  public static final class Builder {
    private ApplicationModule applicationModule;

    private Builder() {}

    public ApplicationComponent build() {
      if (applicationModule == null) {
        throw new IllegalStateException(
            ApplicationModule.class.getCanonicalName() + " must be set");
      }
      return new DaggerApplicationComponent(this);
    }

    public Builder applicationModule(ApplicationModule applicationModule) {
      this.applicationModule = Preconditions.checkNotNull(applicationModule);
      return this;
    }
  }
}
