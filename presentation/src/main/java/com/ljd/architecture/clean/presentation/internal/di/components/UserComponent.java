package com.ljd.architecture.clean.presentation.internal.di.components;

import com.ljd.architecture.clean.presentation.internal.di.PerActivity;
import com.ljd.architecture.clean.presentation.internal.di.modules.ActivityModule;
import com.ljd.architecture.clean.presentation.internal.di.modules.UserModule;

import dagger.Component;

/**
 * Created by ljd on 5/5/16.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class, UserModule.class})
public interface UserComponent {
}
