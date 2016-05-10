package com.ljd.architecture.clean.data.responsitory.datasource;

import android.content.Context;

import com.ljd.architecture.clean.data.entity.mapper.ContributorEntityJsonMapper;
import com.ljd.architecture.clean.data.net.RestApi;
import com.ljd.architecture.clean.data.net.RestApiImpl;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by ljd on 5/7/16.
 */

@Singleton
public class ContributorDataStoreFactory {

    private final Context context;

    @Inject
    public ContributorDataStoreFactory(Context context) {
        this.context = context.getApplicationContext();
    }

    public ContributorDataStore createCloudDataStore() {
        ContributorEntityJsonMapper contributorEntityJsonMapper = new ContributorEntityJsonMapper();
        RestApi restApi = new RestApiImpl(this.context, contributorEntityJsonMapper);

        return new CloudContributorDataStore(restApi);
    }
}
