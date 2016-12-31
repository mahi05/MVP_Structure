package com.mahii.recyclerviewonclicklistnerusinglambda.UI.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mahii.recyclerviewonclicklistnerusinglambda.API.models.MyModel;
import com.mahii.recyclerviewonclicklistnerusinglambda.R;

import java.util.Collections;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<MyModel> myModels;
    private ItemClickListener itemClickListener;

    public MyAdapter() {
        myModels = Collections.emptyList();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View itemView = LayoutInflater
                .from(parent.getContext()).inflate(R.layout.item_track, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        final MyModel myModel = myModels.get(position);

        holder.titleTv.setText((position + 1) + "." + myModel.getTitle());
        holder.subTitleTv.setText(myModel.getSubTitle());

        holder.itemView.setOnClickListener(v -> {
            if (itemClickListener != null) itemClickListener.onItemClick(myModel, position);
        });

    }

    @Override
    public int getItemCount() {
        return myModels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView titleTv;
        TextView subTitleTv;
        View itemView;

        public MyViewHolder(View itemView) {
            super(itemView);
            titleTv = (TextView) itemView.findViewById(R.id.titleTv);
            subTitleTv = (TextView) itemView.findViewById(R.id.subTitleTv);
            this.itemView = itemView;
        }

    }

    public void setModels(List<MyModel> myModels) {
        this.myModels = myModels;
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public interface ItemClickListener {
        void onItemClick(MyModel myModel, int position);
    }

}
