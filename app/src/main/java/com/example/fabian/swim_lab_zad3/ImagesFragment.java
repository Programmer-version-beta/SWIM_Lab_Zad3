package com.example.fabian.swim_lab_zad3;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class ImagesFragment extends Fragment {
    private static final String KEY = "index";
    ImageView image1;
    ImageView image2;
    ImageView image3;
    ImageView image4;
    ImageView image5;
    ImageView image6;
    int index;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater
                .inflate(R.layout.fragment_photos, container, false);
        index = getArguments().getInt(KEY);
        initImages(view);

        return view;
    }

    public void initImages(View view){
        image1 = (ImageView) view.findViewById(R.id.image1);
        image2 = (ImageView) view.findViewById(R.id.image2);
        image3 = (ImageView) view.findViewById(R.id.image3);
        image4 = (ImageView) view.findViewById(R.id.image4);
        image5 = (ImageView) view.findViewById(R.id.image5);
        image6 = (ImageView) view.findViewById(R.id.image6);

        image1.setImageResource(MainActivity.movies.get(index).getImages(0));
        image2.setImageResource(MainActivity.movies.get(index).getImages(1));
        image3.setImageResource(MainActivity.movies.get(index).getImages(2));
        image4.setImageResource(MainActivity.movies.get(index).getImages(3));
        image5.setImageResource(MainActivity.movies.get(index).getImages(4));
        image6.setImageResource(MainActivity.movies.get(index).getImages(5));
    }

    public static ImagesFragment newInstance(int index) {

        ImagesFragment f = new ImagesFragment();
        Bundle b = new Bundle();
        b.putInt(KEY, index);

        f.setArguments(b);

        return f;
    }
}
