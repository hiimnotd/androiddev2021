package vn.edu.usth.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class WeatherActivity<DetailFragment> extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        ForecastFragment forecastFragment = new ForecastFragment();
        getSupportFragmentManager().beginTransaction().add(
                R.id.Fragment_container, forecastFragment).commit();

        Log.i("Activity LifeCycle","OnCreate_");
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.i("Activity LifeCycle","OnStart_");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.i("Activity LifeCycle","OnResume_");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.i("Activity LifeCycle","OnPause_");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.i("Activity LifeCycle","OnStop_");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i("Activity LifeCycle","OnDestroy_");
    }
}
