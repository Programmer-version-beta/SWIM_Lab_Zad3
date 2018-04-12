package com.example.fabian.swim_lab_zad3;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class MyAdapter extends RecyclerView.Adapter {

    private RecyclerView recyclerView;
    private Context context;
    private static final String KEY = "index";

    private class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;
        TextView tvGenre;
        ImageView ivImage;

        MyViewHolder(View pItem) {
            super(pItem);
            tvTitle = (TextView) pItem.findViewById(R.id.movie_title);
            tvGenre = (TextView) pItem.findViewById(R.id.movie_genre);
            ivImage = (ImageView) pItem.findViewById(R.id.movie_image);
        }
    }

    MyAdapter(RecyclerView recyclerView, Context context){
        this.recyclerView = recyclerView;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, InfoAboutMovie.class);
                int index = recyclerView.getChildAdapterPosition(v);
                intent.putExtra(KEY, index);
                context.startActivity(intent);
            }
        });

        view.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {
                int positionToDelete = recyclerView.getChildAdapterPosition(v);
                MainActivity.movies.remove(positionToDelete);
                notifyItemRemoved(positionToDelete);
                return false;
            }
        });

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((MyViewHolder) holder).tvTitle.setText(MainActivity.movies.get(position).getTitle());
        ((MyViewHolder) holder).tvGenre.setText(MainActivity.movies.get(position).getGenre());
        ((MyViewHolder) holder).ivImage.setImageResource(MainActivity.movies.get(position).getImageUrl());
    }

    @Override
    public int getItemCount() {
        return MainActivity.movies.size();
    }
}