package com.example.weatherapplication.viewModel;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.util.Log;

import com.example.weatherapplication.Adapter.RecyclerAdapter;
import com.example.weatherapplication.Retrofit.ClientInstance;
import com.example.weatherapplication.Retrofit.ServiceLayer;
import com.example.weatherapplication.model.Example;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

public class MyViewModel implements LifecycleObserver {

    public List<ItemViewModel> itemViewModelList = new ArrayList<>();
    public RecyclerAdapter recyclerAdapter = new RecyclerAdapter(itemViewModelList);

    public List<String> cityNames = new ArrayList<>();


    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void init() {
        cityNames();
        getCityWeather();
    }
    public void getCityWeather() {
        for (String city : cityNames) {
            ClientInstance client = ServiceLayer.getRetrofitInstance().create(ClientInstance.class);

            Call<Example> call = client.getCurrentCity(city);

            call.enqueue(new Callback<Example>() {
                @Override
                public void onResponse(Call<Example> call, Response<Example> response) {
                    Example example = response.body();
                    if (example != null) {
                         ItemViewModel itemViewModel = new ItemViewModel();
                        itemViewModel.setCity(example.name);
                        itemViewModel.setDescription(example.weather.get(0).description);
                        itemViewModel.setTemperature(String.valueOf(example.getMainValue().temp));
                        itemViewModelList.add(itemViewModel);
                    }
                    recyclerAdapter.notifyDataSetChanged();
                }

                @Override
                public void onFailure(Call<Example> call, Throwable t) {
                    Log.d(TAG, "onFailure: Something went wrong");
                }
            });
        }
    }

    public void cityNames() {
        cityNames.add("chennai");
        cityNames.add("london");
        cityNames.add("maldives");
        cityNames.add("singapore");
        cityNames.add("delhi");
        cityNames.add("mumbai");
        cityNames.add("goa");
        cityNames.add("New york");
    }

    public RecyclerAdapter getRecyclerAdapter(){
        return recyclerAdapter;
    }
}
