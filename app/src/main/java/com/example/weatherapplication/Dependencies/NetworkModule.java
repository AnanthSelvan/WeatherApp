package com.example.weatherapplication.Dependencies;

import com.example.weatherapplication.Retrofit.ClientInstance;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {

    public static String BASE_URL = "https://community-open-weather-map.p.rapidapi.com";

    @Singleton
    @Provides
    public ClientInstance getRetrofitInstance() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ClientInstance.class);
    }
}
