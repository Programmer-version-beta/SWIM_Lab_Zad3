package com.example.fabian.swim_lab_zad3;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class ActorsFragment extends Fragment{
    private static final String KEY = "index";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater
                .inflate(R.layout.fragment_actors, container, false);
        initList(view, getArguments().getInt(KEY));

        return view;
    }

    private void initList(View view, int index){
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.actors);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(new MyAdapterForActors(recyclerView, view.getContext(), index));
    }

    public static ActorsFragment newInstance(int index) {

        ActorsFragment f = new ActorsFragment();
        Bundle b = new Bundle();
        b.putInt(KEY, index);

        f.setArguments(b);

        return f;
    }
}

