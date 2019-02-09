package com.gdg.app.di.component;

import com.gdg.app.di.PerActivity;
import com.gdg.app.di.module.ActivityModule;
import com.gdg.app.ui.login.LoginActivity;
import com.gdg.app.ui.main.MainActivity;
import com.gdg.app.ui.main.PersonAdapter;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    // Main Screen
    void inject(MainActivity activity);
    void inject(PersonAdapter adapter);

    // Login Screen
    void inject(LoginActivity activity);

}
