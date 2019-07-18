package com.example.weatherapplication.Dependencies;

import com.example.weatherapplication.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilderModule {

    @ContributesAndroidInjector
    abstract MainActivity mainActivityProvider();


}
