package com.example.weatherapplication.Retrofit;

import com.example.weatherapplication.model.Example;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class ServiceManager {

    ClientInstance clientInstance;

    @Inject
    public ServiceManager(ClientInstance clientInstance) {
        this.clientInstance = clientInstance;
    }

    public Observable<Example> getCurrentCity(String place) {
        return clientInstance.getCurrentCity(place).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }
}
