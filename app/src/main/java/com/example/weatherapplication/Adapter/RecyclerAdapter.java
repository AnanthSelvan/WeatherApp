package com.example.weatherapplication.Adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.weatherapplication.R;
import com.example.weatherapplication.databinding.RecyclerviewBinding;
import com.example.weatherapplication.viewModel.ItemViewModel;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    public List<ItemViewModel> itemViewModel;

    public RecyclerAdapter(List<ItemViewModel> itemViewModel) {
        this.itemViewModel = itemViewModel;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        RecyclerviewBinding recyclerviewBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.recyclerview,parent,false);
        return new ViewHolder(recyclerviewBinding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ItemViewModel itemViewModelObject = itemViewModel.get(position);
        holder.bind(itemViewModelObject);
    }

    @Override
    public int getItemCount() {
        return itemViewModel.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public RecyclerviewBinding recyclerviewBinding;

        public ViewHolder(RecyclerviewBinding recyclerviewBinding) {
            super(recyclerviewBinding.getRoot());
            this.recyclerviewBinding = recyclerviewBinding;
        }

        public void bind(ItemViewModel itemViewModel){
           recyclerviewBinding.setItemViewModel(itemViewModel);
           recyclerviewBinding.executePendingBindings();
        }
    }
            }
