package com.example.kanokk.myapplication.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kanokk.myapplication.R;
import com.example.kanokk.myapplication.model.BookModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<BookModel> modelList;


    public MyAdapter(List<BookModel> data){
        modelList = data;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.id)
        TextView id;
        @BindView(R.id.test)
        TextView test;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rows_book_items, null);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if(modelList!=null) {
            holder.id.setText(modelList.get(position).getId());
            holder.test.setText(modelList.get(position).getTitle());
        }
    }

    @Override
    public int getItemCount() {
        if(modelList!=null){
            return modelList.size();
        }else{
            return  0;
        }
    }
}
