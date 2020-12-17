package vn.edu.usth.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;

import com.google.android.material.tabs.TabLayout;

public class WeatherActivity<DetailFragment> extends AppCompatActivity {

    public class HomeFragmentPagerAdapter extends FragmentPagerAdapter {
        private final int PAGE_COUNT = 3;
        private String titles[] = new String[] { "Hanoi, Vietnam", "Paris, France", "Toulouse, France" };
        public HomeFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return PAGE_COUNT;
        }

        @Override
        public Fragment getItem(int page) {
            switch (page) {
                case 0: return HanoiFragment.newInstance();
                case 1: return ParisFragment.newInstance();
                case 2: return ToulouseFragment.newInstance();
            }
            return new Fragment();
        }

        @Override
        public CharSequence getPageTitle(int page) {
            return titles[page];
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        PagerAdapter adapter = new HomeFragmentPagerAdapter(getSupportFragmentManager());
        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        pager.setOffscreenPageLimit(3);
        pager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab);
        tabLayout.setupWithViewPager(pager);

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
