package com.ljd.architecture.clean.data.entity.mapper;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.ljd.architecture.clean.data.entity.ContributorEntity;

import java.lang.reflect.Type;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by ljd on 5/7/16.
 */
public class ContributorEntityJsonMapper {

    private final Gson gson;

    @Inject
    public ContributorEntityJsonMapper() {
        this.gson = new Gson();
    }

    public ContributorEntity transformUserEntity(String contributorJsonResponse) throws JsonSyntaxException {
        try {
            Type contributorEntityType = new TypeToken<ContributorEntity>() {}.getType();
            ContributorEntity contributorEntity = this.gson.fromJson(contributorJsonResponse, contributorEntityType);

            return contributorEntity;
        } catch (JsonSyntaxException jsonException) {
            throw jsonException;
        }
    }

    public List<ContributorEntity> transformUserEntityCollection(String contributorListJsonResponse)
            throws JsonSyntaxException {

        List<ContributorEntity> contributorEntityCollection;
        try {
            Type listOfUserEntityType = new TypeToken<List<ContributorEntity>>() {}.getType();
            contributorEntityCollection = this.gson.fromJson(contributorListJsonResponse, listOfUserEntityType);

            return contributorEntityCollection;
        } catch (JsonSyntaxException jsonException) {
            throw jsonException;
        }
    }
}
