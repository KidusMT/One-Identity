package com.gdg.app.di.component;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import com.gdg.app.data.DataManager;
import com.gdg.app.di.module.ActivityModule;
import com.gdg.app.di.module.ActivityModule_ProvideActivityFactory;
import com.gdg.app.di.module.ActivityModule_ProvideCompositeDisposableFactory;
import com.gdg.app.di.module.ActivityModule_ProvideLinearLayoutManagerFactory;
import com.gdg.app.di.module.ActivityModule_ProvideLoginPresenterFactory;
import com.gdg.app.di.module.ActivityModule_ProvideMainPresenterFactory;
import com.gdg.app.di.module.ActivityModule_ProvidePostAdapterFactory;
import com.gdg.app.di.module.ActivityModule_ProvideRegisterPresenterFactory;
import com.gdg.app.di.module.ActivityModule_ProvideSchedulerProviderFactory;
import com.gdg.app.ui.login.LoginActivity;
import com.gdg.app.ui.login.LoginActivity_MembersInjector;
import com.gdg.app.ui.login.LoginMvpPresenter;
import com.gdg.app.ui.login.LoginMvpView;
import com.gdg.app.ui.login.LoginPresenter;
import com.gdg.app.ui.login.LoginPresenter_Factory;
import com.gdg.app.ui.main.MainActivity;
import com.gdg.app.ui.main.MainActivity_MembersInjector;
import com.gdg.app.ui.main.MainMvpPresenter;
import com.gdg.app.ui.main.MainMvpView;
import com.gdg.app.ui.main.MainPresenter;
import com.gdg.app.ui.main.MainPresenter_Factory;
import com.gdg.app.ui.main.PersonAdapter;
import com.gdg.app.ui.register.RegisterActivity;
import com.gdg.app.ui.register.RegisterActivity_MembersInjector;
import com.gdg.app.ui.register.RegisterMvpPresenter;
import com.gdg.app.ui.register.RegisterMvpView;
import com.gdg.app.ui.register.RegisterPresenter;
import com.gdg.app.ui.register.RegisterPresenter_Factory;
import com.gdg.app.utils.rx.SchedulerProvider;
import dagger.MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import dagger.internal.Preconditions;
import io.reactivex.disposables.CompositeDisposable;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerActivityComponent implements ActivityComponent {
  private Provider<DataManager> getDataManagerProvider;

  private Provider<SchedulerProvider> provideSchedulerProvider;

  private Provider<CompositeDisposable> provideCompositeDisposableProvider;

  private Provider<MainPresenter<MainMvpView>> mainPresenterProvider;

  private Provider<MainMvpPresenter<MainMvpView>> provideMainPresenterProvider;

  private Provider<PersonAdapter> providePostAdapterProvider;

  private Provider<AppCompatActivity> provideActivityProvider;

  private Provider<LinearLayoutManager> provideLinearLayoutManagerProvider;

  private MembersInjector<MainActivity> mainActivityMembersInjector;

  private Provider<RegisterPresenter<RegisterMvpView>> registerPresenterProvider;

  private Provider<RegisterMvpPresenter<RegisterMvpView>> provideRegisterPresenterProvider;

  private MembersInjector<RegisterActivity> registerActivityMembersInjector;

  private Provider<LoginPresenter<LoginMvpView>> loginPresenterProvider;

  private Provider<LoginMvpPresenter<LoginMvpView>> provideLoginPresenterProvider;

  private MembersInjector<LoginActivity> loginActivityMembersInjector;

  private DaggerActivityComponent(Builder builder) {
    assert builder != null;
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {

    this.getDataManagerProvider =
        new Factory<DataManager>() {
          private final ApplicationComponent applicationComponent = builder.applicationComponent;

          @Override
          public DataManager get() {
            return Preconditions.checkNotNull(
                applicationComponent.getDataManager(),
                "Cannot return null from a non-@Nullable component method");
          }
        };

    this.provideSchedulerProvider =
        ActivityModule_ProvideSchedulerProviderFactory.create(builder.activityModule);

    this.provideCompositeDisposableProvider =
        ActivityModule_ProvideCompositeDisposableFactory.create(builder.activityModule);

    this.mainPresenterProvider =
        MainPresenter_Factory.create(
            MembersInjectors.<MainPresenter<MainMvpView>>noOp(),
            getDataManagerProvider,
            provideSchedulerProvider,
            provideCompositeDisposableProvider);

    this.provideMainPresenterProvider =
        DoubleCheck.provider(
            ActivityModule_ProvideMainPresenterFactory.create(
                builder.activityModule, mainPresenterProvider));

    this.providePostAdapterProvider =
        ActivityModule_ProvidePostAdapterFactory.create(builder.activityModule);

    this.provideActivityProvider =
        ActivityModule_ProvideActivityFactory.create(builder.activityModule);

    this.provideLinearLayoutManagerProvider =
        ActivityModule_ProvideLinearLayoutManagerFactory.create(
            builder.activityModule, provideActivityProvider);

    this.mainActivityMembersInjector =
        MainActivity_MembersInjector.create(
            provideMainPresenterProvider,
            providePostAdapterProvider,
            provideLinearLayoutManagerProvider);

    this.registerPresenterProvider =
        RegisterPresenter_Factory.create(
            MembersInjectors.<RegisterPresenter<RegisterMvpView>>noOp(),
            getDataManagerProvider,
            provideSchedulerProvider,
            provideCompositeDisposableProvider);

    this.provideRegisterPresenterProvider =
        DoubleCheck.provider(
            ActivityModule_ProvideRegisterPresenterFactory.create(
                builder.activityModule, registerPresenterProvider));

    this.registerActivityMembersInjector =
        RegisterActivity_MembersInjector.create(
            provideRegisterPresenterProvider, provideLinearLayoutManagerProvider);

    this.loginPresenterProvider =
        LoginPresenter_Factory.create(
            MembersInjectors.<LoginPresenter<LoginMvpView>>noOp(),
            getDataManagerProvider,
            provideSchedulerProvider,
            provideCompositeDisposableProvider);

    this.provideLoginPresenterProvider =
        DoubleCheck.provider(
            ActivityModule_ProvideLoginPresenterFactory.create(
                builder.activityModule, loginPresenterProvider));

    this.loginActivityMembersInjector =
        LoginActivity_MembersInjector.create(provideLoginPresenterProvider);
  }

  @Override
  public void inject(MainActivity activity) {
    mainActivityMembersInjector.injectMembers(activity);
  }

  @Override
  public void inject(PersonAdapter adapter) {
    MembersInjectors.<PersonAdapter>noOp().injectMembers(adapter);
  }

  @Override
  public void inject(RegisterActivity activity) {
    registerActivityMembersInjector.injectMembers(activity);
  }

  @Override
  public void inject(LoginActivity activity) {
    loginActivityMembersInjector.injectMembers(activity);
  }

  public static final class Builder {
    private ActivityModule activityModule;

    private ApplicationComponent applicationComponent;

    private Builder() {}

    public ActivityComponent build() {
      if (activityModule == null) {
        throw new IllegalStateException(ActivityModule.class.getCanonicalName() + " must be set");
      }
      if (applicationComponent == null) {
        throw new IllegalStateException(
            ApplicationComponent.class.getCanonicalName() + " must be set");
      }
      return new DaggerActivityComponent(this);
    }

    public Builder activityModule(ActivityModule activityModule) {
      this.activityModule = Preconditions.checkNotNull(activityModule);
      return this;
    }

    public Builder applicationComponent(ApplicationComponent applicationComponent) {
      this.applicationComponent = Preconditions.checkNotNull(applicationComponent);
      return this;
    }
  }
}
