package com.ljd.architecture.clean.data.net;

import android.content.Context;
import android.util.Log;

import com.ljd.architecture.clean.data.entity.ContributorEntity;
import com.ljd.architecture.clean.data.entity.mapper.ContributorEntityJsonMapper;

import java.io.IOException;
import java.util.List;

import okhttp3.ResponseBody;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by ljd on 5/7/16.
 */
public class RestApiImpl implements RestApi {

    private final Context context;
    private final ContributorEntityJsonMapper contributorEntityJsonMapper;

    public RestApiImpl(Context context, ContributorEntityJsonMapper contributorEntityJsonMapper) {
        if (context == null || contributorEntityJsonMapper == null) {
            throw new IllegalArgumentException("The constructor parameters cannot be null!!!");
        }
        this.context = context;
        this.contributorEntityJsonMapper = contributorEntityJsonMapper;
    }

    @Override
    public Observable<List<ContributorEntity>> contributorEntityList() {

        return GitHubService
                .getMspApiService()
                .contributors("square","retrofit")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
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
