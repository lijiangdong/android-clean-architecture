package com.ljd.architecture.clean.data.responsitory.datasource;

import com.ljd.architecture.clean.data.entity.ContributorEntity;
import com.ljd.architecture.clean.data.net.RestApi;

import java.util.List;

import rx.Observable;

/**
 * Created by ljd on 5/7/16.
 */
public class CloudContributorDataStore implements ContributorDataStore  {
    private final RestApi restApi;


    public CloudContributorDataStore(RestApi restApi) {
        this.restApi = restApi;
    }

    @Override
    public Observable<List<ContributorEntity>> contributorEntityList() {
        return this.restApi.contributorEntityList();
    }
}
