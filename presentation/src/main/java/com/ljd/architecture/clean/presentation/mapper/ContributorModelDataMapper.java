package com.ljd.architecture.clean.presentation.mapper;

import com.ljd.architecture.clean.domain.Contributor;
import com.ljd.architecture.clean.presentation.internal.di.PerActivity;
import com.ljd.architecture.clean.presentation.model.ContributorModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import javax.inject.Inject;

/**
 * Created by ljd on 5/6/16.
 */

@PerActivity
public class ContributorModelDataMapper {

    @Inject
    public ContributorModelDataMapper() {
    }

    public ContributorModel transform(Contributor contributor){
        if (contributor == null){
            throw new IllegalArgumentException("Cannot transform a null value");
        }

        ContributorModel contributorModel = new ContributorModel();
        contributorModel.setContributions(contributor.getContributions());
        contributorModel.setLogin(contributor.getLogin());

        return contributorModel;
    }

    public Collection<ContributorModel> transform(Collection<Contributor> contributorCollection){
        Collection<ContributorModel> contributorModelCollection;

        if (contributorCollection != null && !contributorCollection.isEmpty()){

            contributorModelCollection = new ArrayList<>();
            for (Contributor contributor : contributorCollection){
                contributorModelCollection.add(transform(contributor));
            }
        }else {
            contributorModelCollection = Collections.emptyList();
        }

        return contributorModelCollection;
    }
}
