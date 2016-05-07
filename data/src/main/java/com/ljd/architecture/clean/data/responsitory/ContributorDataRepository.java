package com.ljd.architecture.clean.data.responsitory;

import com.ljd.architecture.clean.data.entity.mapper.ContributorEntityDataMapper;
import com.ljd.architecture.clean.data.entity.mapper.ContributorEntityJsonMapper;
import com.ljd.architecture.clean.data.responsitory.datasource.ContributorDataStore;
import com.ljd.architecture.clean.data.responsitory.datasource.ContributorDataStoreFactory;
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

    ContributorDataStoreFactory contributorDataStoreFactory;
    ContributorEntityDataMapper contributorEntityDataMapper;

    @Inject
    public ContributorDataRepository(ContributorDataStoreFactory contributorDataStoreFactory,
                                     ContributorEntityDataMapper contributorEntityDataMapper) {
        this.contributorDataStoreFactory = contributorDataStoreFactory;
        this.contributorEntityDataMapper = contributorEntityDataMapper;
    }




    @Override
    public Observable<List<Contributor>> contributors() {
        final ContributorDataStore contributorDataStore = this.contributorDataStoreFactory.createCloudDataStore();

        return contributorDataStore
                .contributorEntityList()
                .map(contributorEntities ->
                    this.contributorEntityDataMapper.transform(contributorEntities));
    }
}
