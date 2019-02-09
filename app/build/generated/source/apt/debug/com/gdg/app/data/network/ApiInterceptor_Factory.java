package com.gdg.app.data.network;

import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ApiInterceptor_Factory implements Factory<ApiInterceptor> {
  private final Provider<ApiHeader> headerProvider;

  public ApiInterceptor_Factory(Provider<ApiHeader> headerProvider) {
    assert headerProvider != null;
    this.headerProvider = headerProvider;
  }

  @Override
  public ApiInterceptor get() {
    return new ApiInterceptor(headerProvider.get());
  }

  public static Factory<ApiInterceptor> create(Provider<ApiHeader> headerProvider) {
    return new ApiInterceptor_Factory(headerProvider);
  }
}
