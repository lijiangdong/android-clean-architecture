package com.ljd.architecture.clean.presentation.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.ljd.architecture.clean.presentation.R;
import com.ljd.architecture.clean.presentation.internal.di.HasComponent;
import com.ljd.architecture.clean.presentation.internal.di.components.ContributorComponent;
import com.ljd.architecture.clean.presentation.internal.di.components.DaggerContributorComponent;
import com.ljd.architecture.clean.presentation.view.fragment.ContributorListFragment;

public class UserListActivity extends BaseActivity implements HasComponent<ContributorComponent>{

    private ContributorComponent contributorComponent;

    public static Intent getCallingIntent(Context context) {
        return new Intent(context, UserListActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);
        this.initializeInjector();
        if (savedInstanceState == null) {
            addFragment(R.id.fragmentContainer, new ContributorListFragment());
        }
    }

    private void initializeInjector(){
        this.contributorComponent = DaggerContributorComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .build();
    }
    @Override
    public ContributorComponent getComponent() {
        return contributorComponent;
    }
}
