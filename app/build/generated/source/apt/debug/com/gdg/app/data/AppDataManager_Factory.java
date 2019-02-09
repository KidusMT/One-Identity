package com.gdg.app.data;

import com.gdg.app.data.db.DbHelper;
import com.gdg.app.data.network.ApiHelper;
import com.gdg.app.data.prefs.PreferencesHelper;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AppDataManager_Factory implements Factory<AppDataManager> {
  private final Provider<DbHelper> dbHelperProvider;

  private final Provider<PreferencesHelper> preferencesHelperProvider;

  private final Provider<ApiHelper> apiHelperProvider;

  public AppDataManager_Factory(
      Provider<DbHelper> dbHelperProvider,
      Provider<PreferencesHelper> preferencesHelperProvider,
      Provider<ApiHelper> apiHelperProvider) {
    assert dbHelperProvider != null;
    this.dbHelperProvider = dbHelperProvider;
    assert preferencesHelperProvider != null;
    this.preferencesHelperProvider = preferencesHelperProvider;
    assert apiHelperProvider != null;
    this.apiHelperProvider = apiHelperProvider;
  }

  @Override
  public AppDataManager get() {
    return new AppDataManager(
        dbHelperProvider.get(), preferencesHelperProvider.get(), apiHelperProvider.get());
  }

  public static Factory<AppDataManager> create(
      Provider<DbHelper> dbHelperProvider,
      Provider<PreferencesHelper> preferencesHelperProvider,
      Provider<ApiHelper> apiHelperProvider) {
    return new AppDataManager_Factory(
        dbHelperProvider, preferencesHelperProvider, apiHelperProvider);
  }
}
