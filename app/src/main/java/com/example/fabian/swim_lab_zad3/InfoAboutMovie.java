package com.example.fabian.swim_lab_zad3;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

public class InfoAboutMovie extends AppCompatActivity implements MyFragment.MyActivityListener {

    ImageView ivImage;
    TextView tvTitle;
    TextView tvGenre;
    ViewPager pager;
    int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_about_movie);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        index = getIntent().getExtras().getInt("index");
        initViews();
    }

    public void initViews(){
        pager = (ViewPager) findViewById(R.id.viewPager);
        pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));

        ivImage = findViewById(R.id.imageMovie);
        tvTitle = findViewById(R.id.movie_title_info);
        tvGenre = findViewById(R.id.movie_genre_info);
        ivImage.setImageResource(MainActivity.movies.get(index).getImageUrl());
        tvTitle.setText(MainActivity.movies.get(index).getTitle());
        tvGenre.setText(MainActivity.movies.get(index).getGenre());
    }

    private class MyPagerAdapter extends FragmentPagerAdapter {

        MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int pos) {
            switch(pos) {

                case 0: return ImagesFragment.newInstance(index);
                case 1: return ActorsFragment.newInstance(index);
                default: return ImagesFragment.newInstance(index);
            }
        }

        @Override
        public int getCount() {
            return 2;
        }
    }

    @Override
    public void sendMessage(String msg) {
        
    }
}
