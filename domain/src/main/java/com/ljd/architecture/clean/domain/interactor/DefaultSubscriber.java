package com.ljd.architecture.clean.domain.interactor;

import rx.Subscriber;

/**
 * Created by ljd on 5/4/16.
 */
public class DefaultSubscriber<T> extends Subscriber<T> {

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onNext(T t) {

    }
}
