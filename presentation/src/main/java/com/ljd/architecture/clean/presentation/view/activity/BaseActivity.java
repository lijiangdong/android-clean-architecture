package com.ljd.architecture.clean.presentation.view.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;

import com.ljd.architecture.clean.presentation.AndroidApplication;
import com.ljd.architecture.clean.presentation.internal.di.components.ApplicationComponent;
import com.ljd.architecture.clean.presentation.internal.di.modules.ActivityModule;
import com.ljd.architecture.clean.presentation.navigation.Navigator;

import javax.inject.Inject;

/**
 * Created by ljd on 5/4/16.
 */
public class BaseActivity extends Activity {

    @Inject
    Navigator navigator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getApplicationComponent().inject(this);
    }


    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    protected void addFragment(int containerViewId, Fragment fragment) {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.add(containerViewId, fragment);
        fragmentTransaction.commit();
    }


    protected ApplicationComponent getApplicationComponent() {
        return ((AndroidApplication)getApplication()).getApplicationComponent();
    }


    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }
}
