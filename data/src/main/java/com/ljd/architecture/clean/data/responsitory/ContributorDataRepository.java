package com.ljd.architecture.clean.data.responsitory;

import com.ljd.architecture.clean.domain.Contributor;
import com.ljd.architecture.clean.domain.reponsitory.ContributorRepository;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;

/**
 * Created by ljd on 5/6/16.
 */

@Singleton
public class ContributorDataRepository implements ContributorRepository {

    @Inject
    public ContributorDataRepository() {
    }

    @Override
    public Observable<List<Contributor>> contributors() {
        return null;
    }
}
