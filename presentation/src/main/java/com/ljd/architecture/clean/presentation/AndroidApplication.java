package com.ljd.architecture.clean.presentation;

import android.app.Application;

import com.ljd.architecture.clean.presentation.internal.di.components.ApplicationComponent;
import com.ljd.architecture.clean.presentation.internal.di.components.DaggerApplicationComponent;
import com.ljd.architecture.clean.presentation.internal.di.modules.ApplicationModule;

/**
 * Created by ljd on 5/4/16.
 */
public class AndroidApplication extends Application {
    private ApplicationComponent applicationComponent;

    @Override public void onCreate() {
        super.onCreate();
        this.initializeInjector();
        this.initializeLeakDetection();
    }

    private void initializeInjector() {
        this.applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return this.applicationComponent;
    }

    private void initializeLeakDetection() {
//        if (BuildConfig.DEBUG) {
//            LeakCanary.install(this);
//        }
    }
}
