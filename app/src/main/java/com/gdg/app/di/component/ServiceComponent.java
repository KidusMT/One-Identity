package com.gdg.app.di.component;

import com.gdg.app.di.PerService;
import com.gdg.app.di.module.ServiceModule;
import com.gdg.app.service.SyncService;

import dagger.Component;

@PerService
@Component(dependencies = ApplicationComponent.class, modules = ServiceModule.class)
public interface ServiceComponent {

    void inject(SyncService service);

}
