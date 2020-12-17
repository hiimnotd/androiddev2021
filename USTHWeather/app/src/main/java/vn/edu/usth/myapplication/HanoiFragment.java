package vn.edu.usth.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class HanoiFragment extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hanoi, container, false);
    }

    public static Fragment newInstance() {
        HanoiFragment hanoiFragment = new HanoiFragment();
        return hanoiFragment;
    }
}
