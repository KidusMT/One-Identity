package com.gdg.app;

import com.gdg.app.data.DataManager;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class MvpApp_MembersInjector implements MembersInjector<MvpApp> {
  private final Provider<DataManager> mDataManagerProvider;

  public MvpApp_MembersInjector(Provider<DataManager> mDataManagerProvider) {
    assert mDataManagerProvider != null;
    this.mDataManagerProvider = mDataManagerProvider;
  }

  public static MembersInjector<MvpApp> create(Provider<DataManager> mDataManagerProvider) {
    return new MvpApp_MembersInjector(mDataManagerProvider);
  }

  @Override
  public void injectMembers(MvpApp instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.mDataManager = mDataManagerProvider.get();
  }

  public static void injectMDataManager(
      MvpApp instance, Provider<DataManager> mDataManagerProvider) {
    instance.mDataManager = mDataManagerProvider.get();
  }
}
