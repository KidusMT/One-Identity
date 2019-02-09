package com.gdg.app.di.module;

import com.gdg.app.data.network.ApiCall;
import com.gdg.app.data.network.ApiInterceptor;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ApplicationModule_ProvideApiCallFactory implements Factory<ApiCall> {
  private final ApplicationModule module;

  private final Provider<ApiInterceptor> apiInterceptorProvider;

  public ApplicationModule_ProvideApiCallFactory(
      ApplicationModule module, Provider<ApiInterceptor> apiInterceptorProvider) {
    assert module != null;
    this.module = module;
    assert apiInterceptorProvider != null;
    this.apiInterceptorProvider = apiInterceptorProvider;
  }

  @Override
  public ApiCall get() {
    return Preconditions.checkNotNull(
        module.provideApiCall(apiInterceptorProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<ApiCall> create(
      ApplicationModule module, Provider<ApiInterceptor> apiInterceptorProvider) {
    return new ApplicationModule_ProvideApiCallFactory(module, apiInterceptorProvider);
  }

  /** Proxies {@link ApplicationModule#provideApiCall(ApiInterceptor)}. */
  public static ApiCall proxyProvideApiCall(
      ApplicationModule instance, ApiInterceptor apiInterceptor) {
    return instance.provideApiCall(apiInterceptor);
  }
}
