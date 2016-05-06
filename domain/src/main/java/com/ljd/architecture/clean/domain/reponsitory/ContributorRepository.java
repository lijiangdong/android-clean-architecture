package com.ljd.architecture.clean.domain.reponsitory;

import com.ljd.architecture.clean.domain.Contributor;

import java.util.List;

import rx.Observable;

/**
 * Created by ljd on 5/6/16.
 */
public interface ContributorRepository {

    Observable<List<Contributor>> contributors();
}
