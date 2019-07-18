package com.example.weatherapplication.viewModel;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.util.Log;

import com.example.weatherapplication.Adapter.RecyclerAdapter;
import com.example.weatherapplication.Retrofit.ServiceManager;
import com.example.weatherapplication.model.Example;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import static android.content.ContentValues.TAG;

public class MyViewModel implements LifecycleObserver {

    public List<ItemViewModel> itemViewModelList = new ArrayList<>();

    public List<String> cityNames = new ArrayList<>();

    RecyclerAdapter recyclerAdapter;

    ServiceManager serviceManager;
    ItemViewModel itemViewModel;

    @Inject
    public MyViewModel(ServiceManager serviceManager,ItemViewModel itemViewModel) {
        this.serviceManager = serviceManager;
        this.itemViewModel = itemViewModel;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void init() {
        cityNames();
        getCityWeather();
    }

    public void getCityWeather() {
        for (String city : cityNames) {
            serviceManager.getCurrentCity(city).subscribe(this::response, this::failure);
        }
    }

    public void response(Example example) {

        Log.d(TAG, "response() returned: " + example);

        ItemViewModel itemViewModel1 = new ItemViewModel();

        if (example != null) {
            itemViewModel1.setCity(example.name);
            itemViewModel1.setDescription(example.weather.get(0).description);
            itemViewModel1.setTemperature(String.valueOf(example.getMainValue().temp));
            itemViewModelList.add(itemViewModel1);
        }
            recyclerAdapter.notifyDataSetChanged();
        }


    public void failure(Throwable throwable) {
        Log.e(TAG, "failure: Error  " + throwable.getLocalizedMessage());
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

    public RecyclerAdapter getRecyclerAdapter() {
        return recyclerAdapter = new RecyclerAdapter(itemViewModelList);
    }
}
