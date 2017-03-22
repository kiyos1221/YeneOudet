package com.score.kiyos.com.manustrationtracker.adapter;

import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.score.kiyos.com.manustrationtracker.R;
import com.score.kiyos.com.manustrationtracker.utils.Constants;
import com.score.kiyos.com.manustrationtracker.utils.DateUtils;

/**
 * Created by Kiyos on 3/21/2017.
 */

class CalendarAdapter extends BaseAdapter {


    private int position;
    private int month;
    CalendarAdapter(int month) {
        this.position = DateUtils.getFirstDayOfMonth(month);
        this.month = DateUtils.getMonthInPosition(month);

    }

    @Override
    public int getCount() {
        return 36 + position;
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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_view_in_cal, parent, false);

        TextView day = (TextView) view.findViewById(R.id.day_txt);

        Log.d("Menstruation starts", String.valueOf(DateUtils.getNextMenstration(parent.getContext(), position+1)));

        if (position < 7) {
            day.setText(Constants.DAYS_SHORT[position]);
            day.setTextColor(ContextCompat.getColor(parent.getContext(), android.R.color.darker_gray));
        }

        if (position - 6 >= this.position) {

            if (DateUtils.getDate() == position - 5 - this.position && DateUtils.getMonth() == month) {
                day.setTextColor(ContextCompat.getColor(parent.getContext(), R.color.gradientEndColor));
                day.setBackgroundResource(R.drawable.today_bg);
            }
            else if(DateUtils.getNextMenstration(parent.getContext(), position - 6) ==  position - 6){
                day.setBackgroundResource(android.R.color.holo_red_light);
            }
            else {
                day.setBackgroundResource(android.R.color.transparent);
                day.setTextColor(ContextCompat.getColor(parent.getContext(), android.R.color.white));
            }
            day.setText(position - 5 - this.position + "");
        }

        return view;
    }
}
