package com.ljd.architecture.clean.presentation.internal.di.modules;

import android.app.Activity;

import com.ljd.architecture.clean.presentation.internal.di.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ljd on 5/4/16.
 */
@Module
public class ActivityModule {
    private final Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    /**
     * Expose the activity to dependents in the graph.
     */
    @Provides
    @PerActivity
    Activity activity() {
        return this.activity;
    }
}
