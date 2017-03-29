package com.score.kiyos.com.manustrationtracker.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.score.kiyos.com.manustrationtracker.MainActivity;
import com.score.kiyos.com.manustrationtracker.R;
import com.score.kiyos.com.manustrationtracker.adapter.WeekCalendarAdapter;
import com.score.kiyos.com.manustrationtracker.database.RealmPeriodController;
import com.score.kiyos.com.manustrationtracker.model.PeriodDate;
import com.score.kiyos.com.manustrationtracker.utils.DateUtils;

import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 */
public class Ovulation extends Fragment {


    public Ovulation() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ovulation, container, false);

        PeriodDate periodDate = RealmPeriodController.with(getActivity()).getPeriodDate();

        int daysLeftForManustration = DateUtils.getDaysLeftForTheNext(getActivity());

        TextView daysLeft = (TextView) view.findViewById(R.id.days_left);

        daysLeft.setText(String.valueOf(daysLeftForManustration));

        GridView weekDates = (GridView) view.findViewById(R.id.week_dates);

        weekDates.setAdapter(new WeekCalendarAdapter());

        return view;
    }



}
