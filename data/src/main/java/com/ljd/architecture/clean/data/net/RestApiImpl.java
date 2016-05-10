package com.ljd.architecture.clean.data.net;

import com.ljd.architecture.clean.data.entity.ContributorEntity;
import com.ljd.architecture.clean.data.entity.mapper.ContributorEntityJsonMapper;

import java.io.IOException;
import java.util.List;

import rx.Observable;


/**
 * Created by ljd on 5/7/16.
 */
public class RestApiImpl implements RestApi {

    private final ContributorEntityJsonMapper contributorEntityJsonMapper;

    public RestApiImpl(ContributorEntityJsonMapper contributorEntityJsonMapper) {
        if (contributorEntityJsonMapper == null) {
            throw new IllegalArgumentException("The constructor parameters cannot be null!!!");
        }
        this.contributorEntityJsonMapper = contributorEntityJsonMapper;
    }

    @Override
    public Observable<List<ContributorEntity>> contributorEntityList() {

        return GitHubService
                .getMspApiService()
                .contributors("square","retrofit")
                .flatMap(responseBody ->
                    Observable.create(subscriber -> {
                        try {
                            String responseContributorEntities = responseBody.string();
                            if (responseContributorEntities != null){
                                subscriber.onNext(contributorEntityJsonMapper.transformUserEntityCollection(responseContributorEntities));
                                subscriber.onCompleted();
                            } else {
                                subscriber.onError(new Throwable(""));
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }));
    }

}
