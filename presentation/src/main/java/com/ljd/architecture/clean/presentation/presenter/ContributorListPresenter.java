package com.ljd.architecture.clean.presentation.presenter;

import android.util.Log;

import com.ljd.architecture.clean.domain.Contributor;
import com.ljd.architecture.clean.domain.interactor.DefaultSubscriber;
import com.ljd.architecture.clean.domain.interactor.GetContributorList;
import com.ljd.architecture.clean.domain.interactor.UseCase;
import com.ljd.architecture.clean.presentation.internal.di.PerActivity;
import com.ljd.architecture.clean.presentation.mapper.ContributorModelDataMapper;
import com.ljd.architecture.clean.presentation.model.ContributorModel;

import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by ljd on 5/6/16.
 */

@PerActivity
public class ContributorListPresenter implements Presenter {

    private final UseCase getContributorUseCase;
    private final ContributorModelDataMapper contributorModelDataMapper;

    @Inject
    public ContributorListPresenter(@Named("contributorList") UseCase getContributorUseCase,
                                    ContributorModelDataMapper contributorModelDataMapper) {
        this.getContributorUseCase = getContributorUseCase;
        this.contributorModelDataMapper = contributorModelDataMapper;
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {
        this.getContributorUseCase.unsubscribe();
    }

    public void initialize() {
        this.loadUserList();
    }

    public void loadUserList(){
        this.loadContributorList();
    }

    private void loadContributorList(){
        this.getContributorList();
    }

    private void getContributorList(){
        this.getContributorUseCase.execute(new ContributorListSubscriber());
    }

    private void showContributorsCollectionInView(Collection<Contributor> contributorCollection){
        final Collection<ContributorModel> contributorModelCollection =
                this.contributorModelDataMapper.transform(contributorCollection);
        for (ContributorModel contributorModel : contributorModelCollection){
            Log.e("contributorModel",contributorModel.toString());
        }
    }

    private final class ContributorListSubscriber extends DefaultSubscriber<List<Contributor>>{

        @Override
        public void onCompleted() {
            super.onCompleted();
        }

        @Override
        public void onError(Throwable e) {
            super.onError(e);
        }

        @Override
        public void onNext(List<Contributor> contributors) {
            super.onNext(contributors);
            ContributorListPresenter.this.showContributorsCollectionInView(contributors);
        }
    }
}
