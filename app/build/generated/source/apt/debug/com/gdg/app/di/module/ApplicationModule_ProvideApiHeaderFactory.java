package com.gdg.app.di.module;

import com.gdg.app.data.network.ApiHeader;
import com.gdg.app.data.prefs.PreferencesHelper;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ApplicationModule_ProvideApiHeaderFactory implements Factory<ApiHeader> {
  private final ApplicationModule module;

  private final Provider<PreferencesHelper> preferencesHelperProvider;

  public ApplicationModule_ProvideApiHeaderFactory(
      ApplicationModule module, Provider<PreferencesHelper> preferencesHelperProvider) {
    assert module != null;
    this.module = module;
    assert preferencesHelperProvider != null;
    this.preferencesHelperProvider = preferencesHelperProvider;
  }

  @Override
  public ApiHeader get() {
    return Preconditions.checkNotNull(
        module.provideApiHeader(preferencesHelperProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<ApiHeader> create(
      ApplicationModule module, Provider<PreferencesHelper> preferencesHelperProvider) {
    return new ApplicationModule_ProvideApiHeaderFactory(module, preferencesHelperProvider);
  }

  /** Proxies {@link ApplicationModule#provideApiHeader(PreferencesHelper)}. */
  public static ApiHeader proxyProvideApiHeader(
      ApplicationModule instance, PreferencesHelper preferencesHelper) {
    return instance.provideApiHeader(preferencesHelper);
  }
}
