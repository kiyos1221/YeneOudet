package com.score.kiyos.com.manustrationtracker.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.score.kiyos.com.manustrationtracker.R;
import com.score.kiyos.com.manustrationtracker.adapter.CalendarPagerAdapter;
import com.score.kiyos.com.manustrationtracker.utils.DateUtils;

/**
 * A simple {@link Fragment} subclass.
 */
public class Calendar extends Fragment {


    public Calendar() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_menstration, container, false);

        ImageView prev = (ImageView) view.findViewById(R.id.id_prev);

        ImageView next = (ImageView) view.findViewById(R.id.id_next);

        final TextView month_year = (TextView) view.findViewById(R.id.month_year_txt);

        final ViewPager viewPager = (ViewPager) view.findViewById(R.id.calendar_pager);

        viewPager.setAdapter(new CalendarPagerAdapter());

        month_year.setText(DateUtils.getMonthName() + " " + DateUtils.getYear());

        next.bringToFront();

        prev.bringToFront();

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
                month_year.setText(DateUtils.getMonthName(DateUtils.getMonth() - 1) + " " + DateUtils.getYear());
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int month_index = DateUtils.getMonth() + viewPager.getCurrentItem() - 1;
                int year = DateUtils.getYear();

                viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);

                if (month_index > 12) {
                    month_index = 0;
                    year += 1;
                }

                month_year.setText(DateUtils.getMonthName(month_index) + " " + year);
            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        return view;
    }

}
