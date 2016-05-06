package com.ljd.architecture.clean.presentation.internal.di.modules;

import android.content.Context;

import com.ljd.architecture.clean.data.executor.JobExecutor;
import com.ljd.architecture.clean.domain.executor.PostExecutionThread;
import com.ljd.architecture.clean.domain.executor.ThreadExecutor;
import com.ljd.architecture.clean.presentation.AndroidApplication;
import com.ljd.architecture.clean.presentation.UIThread;
import com.ljd.architecture.clean.presentation.navigation.Navigator;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ljd on 5/4/16.
 */
@Module
public class ApplicationModule {

    private final AndroidApplication application;

    public ApplicationModule(AndroidApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return this.application;
    }

    @Provides @Singleton
    ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor) {
        return jobExecutor;
    }

    @Provides @Singleton
    PostExecutionThread providePostExecutionThread(UIThread uiThread) {
        return uiThread;
    }

//    @Provides @Singleton UserCache provideUserCache(UserCacheImpl userCache) {
//        return userCache;
//    }
//
//    @Provides @Singleton ContributorRepository provideUserRepository(UserDataRepository userDataRepository) {
//        return userDataRepository;
//    }

}
