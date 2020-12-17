package vn.edu.usth.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;

public class WeatherActivity<DetailFragment> extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        PagerAdapter adapter = new HomeFragmentPagerAdapter(
                getSupportFragmentManager());
        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        pager.setOffscreenPageLimit(3);
        pager.setAdapter(adapter);

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

    public class HomeFragmentPagerAdapter extends FragmentPagerAdapter {
        private final int PAGE_COUNT = 3;
        private String titles[] = new String[] { "WeatherNForecast", "Weather", "Forecast" };
        public HomeFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }
        @Override
        public int getCount() {
            return PAGE_COUNT; // number of pages for a ViewPager
        }
        @Override
        public Fragment getItem(int page) {
        // returns an instance of Fragment corresponding to the specified page
            switch (page) {
                case 0: return WeatherAndForecastFragment.newInstance();
                case 1: return WeatherFragment.newInstance();
                case 2: return ForecastFragment.newInstance();
            }
            return new EmptyFragment();
        }
        @Override
        public CharSequence getPageTitle(int page) {
        // returns a tab title corresponding to the specified page
            return titles[page];
        }
    }
}
