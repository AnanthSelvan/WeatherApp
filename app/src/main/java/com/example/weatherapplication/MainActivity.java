package com.example.weatherapplication;

import android.arch.lifecycle.LifecycleOwner;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.example.weatherapplication.Adapter.RecyclerAdapter;
import com.example.weatherapplication.databinding.ActivityMainBinding;
import com.example.weatherapplication.viewModel.ItemViewModel;
import com.example.weatherapplication.viewModel.MyViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LifecycleOwner {
public ItemViewModel itemViewModel;
public MyViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        MyViewModel viewModel = new MyViewModel();
        this.getLifecycle().addObserver(viewModel);
        activityMainBinding.setModel(viewModel);
        activityMainBinding.recyclerView.setAdapter(viewModel.getRecyclerAdapter());
        activityMainBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}
