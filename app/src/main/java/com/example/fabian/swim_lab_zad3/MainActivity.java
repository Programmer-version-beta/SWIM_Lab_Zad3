package com.example.fabian.swim_lab_zad3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    public static ArrayList <Movie> movies = new ArrayList <>();
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(movies.size() == 0)
            initData();
        initRecycleView();
    }

    private void initRecycleView(){
        recyclerView = (RecyclerView) findViewById(R.id.movies);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(new MyAdapter(recyclerView, getApplicationContext()));
        setUpItemTouchHelper();
    }

    private void setUpItemTouchHelper() {
        ItemTouchHelper.SimpleCallback simpleItemTouchCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {

            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir) {
                int swipedPosition = viewHolder.getAdapterPosition();
                MyAdapter adapter = (MyAdapter)recyclerView.getAdapter();
                adapter.remove(swipedPosition);
            }

        };
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleItemTouchCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }


    private void initData(){
        ArrayList <Actor> list = new ArrayList<>();
        list.add(new Actor("Tom", "Hanks", 61));
        list.add(new Actor("David", "Morse", 64));
        list.add(new Actor("Bonnie", "Hunt", 56));
        list.add(new Actor("Michael", "Clarke Duncan", 54));
        movies.add(new Movie("Zielona Mila", "Dramat", R.drawable.zielona_mila, list,
                new int[]{R.drawable.zielona_mila, R.drawable.fineasz_i_ferb, R.drawable.interstellar,
                R.drawable.wyspa_tajemnic, R.drawable.incepcja, R.drawable.gladiator}));
        ArrayList <Actor> list2 = new ArrayList<>();
        list2.add(new Actor("Leonardo", "DiCaprio", 43));
        list2.add(new Actor("Joseph", "Gordon-Levitt", 37));
        list2.add(new Actor("Tom", "Hardy", 40));
        list2.add(new Actor("Elen", "Page", 31));
        movies.add(new Movie("Incepcja", "Surrealistyczny", R.drawable.incepcja, list2,
                new int[]{R.drawable.zielona_mila, R.drawable.gladiator, R.drawable.incepcja,
                R.drawable.wyspa_tajemnic, R.drawable.interstellar, R.drawable.fineasz_i_ferb}));
        ArrayList <Actor> list3 = new ArrayList<>();
        list3.add(new Actor("Matthew", "McConaughey", 48));
        list3.add(new Actor("Anne", "Hathaway", 35));
        list3.add(new Actor("Jessica", "Chastain", 41));
        list3.add(new Actor("Bill", "Irwin", 67));
        movies.add(new Movie("Interstellar", "Sci-Fi", R.drawable.interstellar, list3,
                new int[]{R.drawable.zielona_mila, R.drawable.incepcja, R.drawable.gladiator,
                R.drawable.interstellar, R.drawable.fineasz_i_ferb, R.drawable.wyspa_tajemnic}));
        ArrayList <Actor> list4 = new ArrayList<>();
        list4.add(new Actor("Russell", "Crowe", 53));
        list4.add(new Actor("Joaquin", "Phoenix", 43));
        list4.add(new Actor("Connie", "Nielsen", 52));
        list4.add(new Actor("Oliver", "Reed", 61));
        movies.add(new Movie("Gladiator", "Dramat historyczny", R.drawable.gladiator, list4,
                new int[]{R.drawable.zielona_mila, R.drawable.wyspa_tajemnic, R.drawable.incepcja,
                R.drawable.fineasz_i_ferb, R.drawable.gladiator, R.drawable.interstellar}));
        ArrayList <Actor> list5 = new ArrayList<>();
        list5.add(new Actor("Leonardo", "DiCaprio", 43));
        list5.add(new Actor("Mark", "Ruffalo", 50));
        list5.add(new Actor("Ben", "Kingsley", 74));
        list5.add(new Actor("Max", "von Sydow", 88));
        movies.add(new Movie("Wyspa tajemnic", "Dramat", R.drawable.wyspa_tajemnic, list5,
                new int[]{R.drawable.zielona_mila, R.drawable.interstellar, R.drawable.fineasz_i_ferb,
                R.drawable.gladiator, R.drawable.wyspa_tajemnic, R.drawable.incepcja}));
        ArrayList <Actor> list6 = new ArrayList<>();
        list6.add(new Actor("Phineas", "Flynn", 12));
        list6.add(new Actor("Ferb", "Fletcher", 12));
        list6.add(new Actor("Perry", "the Platypus", 5));
        list6.add(new Actor("Heinz", "Doofenschmirtz", 47));
        movies.add(new Movie("Fineasz i Ferb", "Serial animowany" ,R.drawable.fineasz_i_ferb, list6,
                new int[]{R.drawable.gladiator, R.drawable.interstellar, R.drawable.zielona_mila,
                R.drawable.fineasz_i_ferb, R.drawable.incepcja, R.drawable.wyspa_tajemnic}));
    }
}