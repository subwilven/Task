package com.example.android.task;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by eslam on 08-Mar-18.
 */

public class FragmentPageAdapter extends FragmentStatePagerAdapter {
    FragmentManager fm;
    private MainFragment mainFragment;
    private MainFragment mainFragment2;
    private MainFragment mainFragment3;

    public int fragmentNum;

    public FragmentPageAdapter(FragmentManager fm) {
        super(fm);
        this.fm = fm;
        fragmentNum = 3;
        mainFragment = new MainFragment();
        mainFragment2 = new MainFragment();
        mainFragment3 = new MainFragment();
    }

    @Override
    public Fragment getItem(int arg0) {
        switch (arg0) {
            case 0:
                return mainFragment;
            case 1:
                return mainFragment2;
            case 2:
                return mainFragment3;
            default:
                break;
        }
        return null;
    }

    @Override
    public int getCount() {

        return fragmentNum;
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }
}



