package me.zongren.databindingdemo;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import me.zongren.databindingdemo.databinding.ActivityMainItemBinding;

/**
 * Created by zongren on 2017/4/26.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ItemViewHolder> implements ItemEventHandler{
    List<Item> list = new ArrayList<>();

    public MainAdapter() {
        for (int i = 0; i < 100; i++) {
            Item item = new Item(i % 2 == 0, "title" + i);
            list.add(item);
        }
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ActivityMainItemBinding binding = ActivityMainItemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new ItemViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        ActivityMainItemBinding binding = holder.binding;
        binding.setItem(list.get(position));
        binding.setHandler(MainAdapter.this);
        binding.textView.setTag(R.id.tag_position,position);
        binding.checkbox.setTag(R.id.tag_position,position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder{
        public ActivityMainItemBinding binding;
        public ItemViewHolder(ActivityMainItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    @Override
    public void clickTitle(View view){
        int position = (int)view.getTag(R.id.tag_position);
        Item item = list.get(position);
        Log.i("MainAdapter","Click title:"+item.title);
    }

    @Override
    public void clickCheckbox(View view){
        int position = (int)view.getTag(R.id.tag_position);
        Item item = list.get(position);
        Log.i("MainAdapter","Before click,checkbox checked is :"+item.checked);
        item.checked = !item.checked;
        Log.i("MainAdapter","After click,checkbox checked is:"+item.checked);
    }

    @Override
    public void clickTitle(View view, Item item) {
        Log.i("MainAdapter","Click title:"+item.title);
    }
}
