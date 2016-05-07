package com.ljd.architecture.clean.data.entity.mapper;

import com.ljd.architecture.clean.data.entity.ContributorEntity;
import com.ljd.architecture.clean.domain.Contributor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by ljd on 5/7/16.
 */

@Singleton
public class ContributorEntityDataMapper {

    @Inject
    public ContributorEntityDataMapper() {
    }

    public Contributor transform(ContributorEntity contributorEntity) {
        Contributor contributor = null;
        if (contributorEntity != null) {
            contributor.setContributions(contributorEntity.getContributions());
            contributor.setLogin(contributorEntity.getLogin());
        }

        return contributor;
    }

    public List<Contributor> transform(Collection<ContributorEntity> contributorEntityCollection) {
        List<Contributor> userList = new ArrayList<>(20);
        Contributor user;
        for (ContributorEntity contributorEntity : contributorEntityCollection) {
            user = transform(contributorEntity);
            if (user != null) {
                userList.add(user);
            }
        }

        return userList;
    }
}
