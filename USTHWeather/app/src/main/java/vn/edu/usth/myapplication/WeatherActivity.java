package vn.edu.usth.myapplication;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class WeatherActivity<DetailFragment, MediaPlayer> extends AppCompatActivity {

    private MediaPlayer player;

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

//        player = MediaPlayer.create(this,R.raw.yeu);
//        player.start();

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
//
//        player.stop();
//        player.release();
//        player = null;

        Log.i("Activity LifeCycle","OnStop_");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i("Activity LifeCycle","OnDestroy_");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.refresh:
                refresh rf = new refresh();
                rf.execute();
                return true;
            case R.id.setting:
                Intent intent = new Intent(this, PrefActivity.class);
                startActivity(intent);
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    public class refresh extends AsyncTask<Void, Void, Void>{
        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Thread.sleep(5000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            Toast.makeText(getApplicationContext(), "some sample json here", Toast.LENGTH_SHORT).show();
        }
    }
}
