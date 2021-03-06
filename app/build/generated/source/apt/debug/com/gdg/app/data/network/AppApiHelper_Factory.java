package com.gdg.app.data.network;

import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AppApiHelper_Factory implements Factory<AppApiHelper> {
  private final Provider<ApiHeader> apiHeaderProvider;

  private final Provider<ApiCall> apiCallProvider;

  public AppApiHelper_Factory(
      Provider<ApiHeader> apiHeaderProvider, Provider<ApiCall> apiCallProvider) {
    assert apiHeaderProvider != null;
    this.apiHeaderProvider = apiHeaderProvider;
    assert apiCallProvider != null;
    this.apiCallProvider = apiCallProvider;
  }

  @Override
  public AppApiHelper get() {
    return new AppApiHelper(apiHeaderProvider.get(), apiCallProvider.get());
  }

  public static Factory<AppApiHelper> create(
      Provider<ApiHeader> apiHeaderProvider, Provider<ApiCall> apiCallProvider) {
    return new AppApiHelper_Factory(apiHeaderProvider, apiCallProvider);
  }
}
