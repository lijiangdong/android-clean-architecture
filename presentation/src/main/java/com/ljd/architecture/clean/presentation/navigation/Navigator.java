package com.ljd.architecture.clean.presentation.navigation;

import android.content.Context;
import android.content.Intent;

import com.ljd.architecture.clean.presentation.view.activity.UserListActivity;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by ljd on 5/4/16.
 */

//@Singleton
public class Navigator {

    @Inject
    public Navigator() {
        //empty
    }

    public void navigateToUserList(Context context) {
        if (context != null) {
            Intent intentToLaunch = UserListActivity.getCallingIntent(context);
            context.startActivity(intentToLaunch);
        }
    }

}
