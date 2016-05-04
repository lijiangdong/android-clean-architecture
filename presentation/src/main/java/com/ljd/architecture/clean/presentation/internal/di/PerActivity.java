package com.ljd.architecture.clean.presentation.internal.di;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by ljd on 5/4/16.
 */
@Scope
@Retention(RUNTIME)
public @interface PerActivity {}
