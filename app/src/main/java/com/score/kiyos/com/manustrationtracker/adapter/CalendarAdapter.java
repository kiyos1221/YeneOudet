package com.score.kiyos.com.manustrationtracker.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.score.kiyos.com.manustrationtracker.R;
import com.score.kiyos.com.manustrationtracker.database.RealmPeriodController;
import com.score.kiyos.com.manustrationtracker.model.PeriodDate;
import com.score.kiyos.com.manustrationtracker.utils.Constants;
import com.score.kiyos.com.manustrationtracker.utils.DateUtils;

/**
 * Created by Kiyos on 3/21/2017.
 */

class CalendarAdapter extends BaseAdapter {


    private int month;
    private int monthMenstruationStart;
    private Context context;
    private PeriodDate periodDate;
    private boolean updated = false;

    CalendarAdapter(Context context, int month) {
        this.month = month;
        this.context = context;
        monthMenstruationStart = DateUtils.getLocalDateWithGivenMonth(context, month).getDayOfMonth();
        periodDate = RealmPeriodController.with(context).getPeriodDate();
    }

    @Override
    public int getCount() {
        return DateUtils.getNumberOfDays(month) + 6 + DateUtils.getFirstDayOfMonth(month);
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.single_view_in_cal, parent, false);

        TextView day = (TextView) view.findViewById(R.id.day_txt);

        if (position < 7) {
            day.setText(Constants.DAYS_SHORT[position]);
            day.setTextColor(ContextCompat.getColor(context, android.R.color.darker_gray));
        }

        if (position - 6 >= DateUtils.getFirstDayOfMonth(month)) {
            day.setText(position - 5 - DateUtils.getFirstDayOfMonth(month) + "");

            if (DateUtils.getDate() == position - 5 - DateUtils.getFirstDayOfMonth(month) && DateUtils.getMonth() == month) {
                day.setTextColor(ContextCompat.getColor(context, R.color.gradientEndColor));

                day.setBackgroundResource(R.drawable.today_bg);
            } else {
                day.setBackgroundResource(android.R.color.transparent);
                day.setTextColor(ContextCompat.getColor(context, android.R.color.white));
            }
            if (periodDate.getCycleDuration() + DateUtils.getLocalDateWithGivenMonth(context, month).getDayOfMonth() <= DateUtils.getNumberOfDays(month)) {

                for (int i = 0; i < 2; i++) {
                    if (DateUtils.getLocalDateWithGivenMonth(context, month + i).getDayOfMonth() == position - 5 - DateUtils.getFirstDayOfMonth(month)) {
                        day.setTextColor(ContextCompat.getColor(context, android.R.color.holo_red_light));
                    }
                }
                if(!updated){
                    Constants.changedPosition = Constants.changedPosition +1;
                    updated = true;
                }
            } else {
                if (DateUtils.getLocalDateWithGivenMonth(context, month + Constants.changedPosition).getDayOfMonth() == position - 5 - DateUtils.getFirstDayOfMonth(month)) {
                    day.setTextColor(ContextCompat.getColor(context, android.R.color.black));
                }
            }
        }


        return view;
    }
}
