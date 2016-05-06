package com.ljd.architecture.clean.presentation.internal.di.components;

import com.ljd.architecture.clean.presentation.internal.di.PerActivity;
import com.ljd.architecture.clean.presentation.internal.di.modules.ActivityModule;
import com.ljd.architecture.clean.presentation.internal.di.modules.ContributorModule;
import com.ljd.architecture.clean.presentation.view.fragment.ContributorListFragment;

import dagger.Component;

/**
 * Created by ljd on 5/5/16.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class, ContributorModule.class})
public interface ContributorComponent extends ActivityComponent{

    void inject(ContributorListFragment contributorListFragment);
}
