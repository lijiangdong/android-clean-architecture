package com.ljd.architecture.clean.presentation.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.ljd.architecture.clean.presentation.R;
import com.ljd.architecture.clean.presentation.internal.di.HasComponent;
import com.ljd.architecture.clean.presentation.internal.di.components.DaggerUserComponent;
import com.ljd.architecture.clean.presentation.internal.di.components.UserComponent;

public class UserListActivity extends BaseActivity implements HasComponent<UserComponent>{

    private UserComponent userComponent;

    public static Intent getCallingIntent(Context context) {
        return new Intent(context, UserListActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);
        this.initializeInjector();
    }

    private void initializeInjector(){
        this.userComponent = DaggerUserComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .build();
    }
    @Override
    public UserComponent getComponent() {
        return userComponent;
    }
}
