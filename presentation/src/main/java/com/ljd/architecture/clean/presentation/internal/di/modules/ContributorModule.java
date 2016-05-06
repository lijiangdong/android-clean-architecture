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

    private int userId = -1;

    public ContributorModule() {}

    public ContributorModule(int userId) {
        this.userId = userId;
    }

    @Provides
    @PerActivity
    @Named("contributorList")
    UseCase provideGetContributorListUseCase(GetContributorList getContributorList){
        return getContributorList;
    }
}
