package com.example.fabian.swim_lab_zad3;

import android.app.Activity;
import android.app.Fragment;

public class MyFragment extends Fragment {

    private MyActivityListener listener;

    public interface MyActivityListener {
        public void sendMessage(String msg);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        listener = (MyActivityListener) activity;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}
