package com.example.recyclerviewtest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


class RecyclerViewHolder extends RecyclerView.ViewHolder{
    public TextView textView;

    public RecyclerViewHolder(View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.txtAd);
    }
}

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {

    private List<Data> listData = new ArrayList<Data>();

    public RecyclerViewAdapter(List<Data> listData) {
        this.listData = listData;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item,parent,false);
        return new RecyclerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        holder.textView.setText(listData.get(position).getDescription());

    }

    @Override
    public int getItemCount() {
        return listData.size();
    }
}
