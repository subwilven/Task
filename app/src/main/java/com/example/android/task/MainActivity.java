package com.example.android.task;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;

public class MainActivity extends AppCompatActivity {
    ViewPager mViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setElevation(0f);
        mViewPager =  findViewById(R.id.viewpager);
//        if (savedInstanceState == null)
//            getSupportFragmentManager().beginTransaction()
//                    .replace(R.id.main_activity_fragment, new MainFragment()).addToBackStack(null).commit();
        mViewPager.setAdapter(new FragmentPageAdapter(getSupportFragmentManager()));
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);

        return true;
    }

}

