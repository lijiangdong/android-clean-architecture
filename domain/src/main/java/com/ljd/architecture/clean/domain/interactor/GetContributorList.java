package com.ljd.architecture.clean.domain.interactor;

import com.ljd.architecture.clean.domain.executor.PostExecutionThread;
import com.ljd.architecture.clean.domain.executor.ThreadExecutor;
import com.ljd.architecture.clean.domain.reponsitory.ContributorRepository;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by ljd on 5/6/16.
 */

public class GetContributorList extends UseCase {

    private final ContributorRepository contributorRepository;

    @Inject
    public GetContributorList(ContributorRepository contributorRepository,ThreadExecutor threadExecutor,
                                 PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.contributorRepository = contributorRepository;
    }

    @Override
    public Observable buildUseCaseObservable() {
        return this.contributorRepository.contributors();
    }
}
