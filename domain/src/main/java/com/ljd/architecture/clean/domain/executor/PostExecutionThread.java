package com.ljd.architecture.clean.domain.executor;


import rx.Scheduler;

/**
 * Created by ljd on 5/4/16.
 */
public interface PostExecutionThread {
    Scheduler getScheduler();
}
