package com.ljd.architecture.clean.presentation.internal.di.components;

import android.app.Activity;

import com.ljd.architecture.clean.presentation.internal.di.PerActivity;
import com.ljd.architecture.clean.presentation.internal.di.modules.ActivityModule;

import dagger.Component;
import dagger.Subcomponent;

/**
 * Created by ljd on 5/4/16.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    Activity activity();
}
