package com.ljd.architecture.clean.presentation.internal.di.modules;

import com.ljd.architecture.clean.domain.interactor.GetContributorList;
import com.ljd.architecture.clean.domain.interactor.UseCase;
import com.ljd.architecture.clean.presentation.internal.di.PerActivity;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ljd on 5/5/16.
 */

@Module
public class ContributorModule{

    public ContributorModule() {}

    @Provides
    @PerActivity
    @Named("contributorList")
    public UseCase provideGetContributorListUseCase(
            GetContributorList getContributorList){
        return getContributorList;
    }
}
