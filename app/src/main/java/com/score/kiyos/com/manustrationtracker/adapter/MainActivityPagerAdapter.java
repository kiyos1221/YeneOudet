package com.score.kiyos.com.manustrationtracker.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.score.kiyos.com.manustrationtracker.fragment.Calendar;
import com.score.kiyos.com.manustrationtracker.fragment.Ovulation;
import com.score.kiyos.com.manustrationtracker.fragment.Pregnancy;

/**
 * Created by Kiyos on 3/21/2017.
 */

public class MainActivityPagerAdapter extends FragmentPagerAdapter {
    public MainActivityPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if(position == 0){
            fragment = new Ovulation();
        }
        if(position == 1){
            fragment = new Calendar();
        }
        if(position == 2){
            fragment = new Pregnancy();
        }

        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;

        if(position == 0){
            title = "ውጻት";
        }
        if(position == 1){
            title = "የወር አበባ";
        }
        if(position == 2){
            title = "እርግዝና";
        }

        return title;
    }
}
