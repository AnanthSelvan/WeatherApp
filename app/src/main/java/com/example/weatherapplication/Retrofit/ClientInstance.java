package com.example.weatherapplication.Retrofit;

import com.example.weatherapplication.model.Example;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface ClientInstance {

    @Headers({
            "X-RapidAPI-Key:9dcafd6a6dmsh3e60e80f6becb4bp1fd4aejsnd7bfc9ab267f",
    })

    @GET("/weather")
    Observable<Example> getCurrentCity(@Query("q") String place);

}
