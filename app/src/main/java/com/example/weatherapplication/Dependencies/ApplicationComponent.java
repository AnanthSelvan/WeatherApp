package com.example.weatherapplication.Dependencies;

import android.app.Activity;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {AndroidSupportInjectionModule.class, NetworkModule.class,ActivityBuilderModule.class})
public interface ApplicationComponent extends AndroidInjector<WeatherApplication> {
}
