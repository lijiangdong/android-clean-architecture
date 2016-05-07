package com.ljd.architecture.clean.data.responsitory.datasource;

import com.ljd.architecture.clean.data.entity.ContributorEntity;

import java.util.List;

import rx.Observable;

/**
 * Created by ljd on 5/7/16.
 */
public interface ContributorDataStore {

    Observable<List<ContributorEntity>> contributorEntityList();
}
