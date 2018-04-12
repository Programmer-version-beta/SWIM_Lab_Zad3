package com.example.fabian.swim_lab_zad3;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class MyAdapterForActors extends RecyclerView.Adapter {
    RecyclerView recyclerView;
    private Context context;
    private int index;

    private class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvSurname;
        TextView tvAge;

        MyViewHolder(View pItem) {
            super(pItem);
            tvName = (TextView) pItem.findViewById(R.id.actor_name);
            tvSurname = (TextView) pItem.findViewById(R.id.actor_surname);
            tvAge = (TextView) pItem.findViewById(R.id.actor_age);
        }
    }

    MyAdapterForActors(RecyclerView recyclerView, Context context, int index){
        this.recyclerView = recyclerView;
        this.context = context;
        this.index = index;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_for_actors, parent, false);

        return new MyAdapterForActors.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((MyViewHolder) holder).tvName.setText(MainActivity.movies.get(index).getActors().get(position).getName());
        ((MyViewHolder) holder).tvSurname.setText(MainActivity.movies.get(index).getActors().get(position).getSurname());
        ((MyViewHolder) holder).tvAge.setText(String.format("%s%s", context.getString(R.string.age), String.valueOf(MainActivity.movies.get(index).getActors().get(position).getAge())));
    }

    @Override
    public int getItemCount() {
        return MainActivity.movies.get(index).getActors().size();
    }
}
