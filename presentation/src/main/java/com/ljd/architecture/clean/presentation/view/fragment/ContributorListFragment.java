package com.ljd.architecture.clean.presentation.view.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ljd.architecture.clean.presentation.R;
import com.ljd.architecture.clean.presentation.internal.di.components.ContributorComponent;
import com.ljd.architecture.clean.presentation.presenter.ContributorListPresenter;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContributorListFragment extends BaseFragment {

    @Inject
    ContributorListPresenter contributorListPresenter;

    public ContributorListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getComponent(ContributorComponent.class).inject(this);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_user_list, container, false);
        ButterKnife.bind(this,layout);
        this.loadContributorList();
        return layout;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (savedInstanceState == null){
            this.loadContributorList();
        }
    }

    private void loadContributorList() {
        this.contributorListPresenter.initialize();
    }
}
