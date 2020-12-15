package vn.edu.usth.myapplication;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class WeatherFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View weatherFragment = inflater.inflate(R.layout.fragment_weather, container, false);
        weatherFragment.setBackgroundColor(Color.parseColor("#6FFFAA"));
        return  weatherFragment;
    }
}
