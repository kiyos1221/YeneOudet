package com.score.kiyos.com.manustrationtracker.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.score.kiyos.com.manustrationtracker.R;

/**
 * Created by Kiyos on 3/21/2017.
 */

public class CalendarPagerAdapter extends PagerAdapter {
    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.calendar_view, container, false);
        GridView gridView = (GridView) view.findViewById(R.id.calendar_grid);

        gridView.setAdapter(new CalendarAdapter(position));

        container.addView(gridView);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
