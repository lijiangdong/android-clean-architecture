package com.ljd.architecture.clean.presentation.internal.di.components;

import android.content.Context;

import com.ljd.architecture.clean.domain.executor.PostExecutionThread;
import com.ljd.architecture.clean.domain.executor.ThreadExecutor;
import com.ljd.architecture.clean.presentation.internal.di.modules.ApplicationModule;
import com.ljd.architecture.clean.presentation.view.activity.BaseActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by ljd on 5/4/16.
 */
@Singleton // Constraints this component to one-per-application or unscoped bindings.
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(BaseActivity baseActivity);

    //Exposed to sub-graphs.
    Context context();
    ThreadExecutor threadExecutor();
    PostExecutionThread postExecutionThread();
}
