package com.example.weatherapplication.viewModel;

import android.databinding.BaseObservable;

public class ItemViewModel extends BaseObservable {

    public String city;
    public String description;
    public String temperature;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }
}
