package com.score.kiyos.com.manustrationtracker.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.score.kiyos.com.manustrationtracker.R;
import com.score.kiyos.com.manustrationtracker.adapter.CalendarPagerAdapter;
import com.score.kiyos.com.manustrationtracker.adapter.TimelineAdapter;
import com.score.kiyos.com.manustrationtracker.utils.DateUtils;

/**
 * A simple {@link Fragment} subclass.
 */
public class Calendar extends Fragment {


    int i = 0;

    public Calendar() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_calendar, container, false);

        ImageView prev = (ImageView) view.findViewById(R.id.id_prev);

        ImageView next = (ImageView) view.findViewById(R.id.id_next);

        final TextView month_year = (TextView) view.findViewById(R.id.month_year_txt);

        final ViewPager viewPager = (ViewPager) view.findViewById(R.id.calendar_pager);

        final ListView listView = (ListView) view.findViewById(R.id.timeline_list);

        setAdaperForList(listView, viewPager.getCurrentItem());

        view.findViewById(R.id.date_wrapper).bringToFront();

        viewPager.setAdapter(new CalendarPagerAdapter());

        month_year.setText(DateUtils.getMonthName() + " " + DateUtils.getYear());

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);

                month_year.setText(DateUtils.addMonth(viewPager.getCurrentItem()));
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);

                month_year.setText(DateUtils.addMonth(viewPager.getCurrentItem()));
            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                month_year.setText(DateUtils.addMonth(viewPager.getCurrentItem()));
                setAdaperForList(listView, position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        return view;
    }

    public void setAdaperForList(ListView listView, int position) {
        listView.setAdapter(new TimelineAdapter(position));
    }


}
