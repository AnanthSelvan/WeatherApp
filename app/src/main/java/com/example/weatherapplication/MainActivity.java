package com.example.weatherapplication;

import android.arch.lifecycle.LifecycleOwner;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.example.weatherapplication.databinding.ActivityMainBinding;
import com.example.weatherapplication.viewModel.MyViewModel;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class MainActivity extends AppCompatActivity implements LifecycleOwner {

    @Inject
    MyViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidInjection.inject(this);
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        this.getLifecycle().addObserver(viewModel);

        activityMainBinding.setModel(viewModel);
        activityMainBinding.recyclerView.setAdapter(viewModel.getRecyclerAdapter());
        activityMainBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}
