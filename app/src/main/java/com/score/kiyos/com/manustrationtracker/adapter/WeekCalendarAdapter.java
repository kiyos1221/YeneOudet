package com.score.kiyos.com.manustrationtracker.adapter;

import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.score.kiyos.com.manustrationtracker.R;
import com.score.kiyos.com.manustrationtracker.utils.Constants;
import com.score.kiyos.com.manustrationtracker.utils.DateUtils;

import org.joda.time.DateTime;

/**
 * Created by Kiyos Solomon on 3/27/2017.
 */

public class WeekCalendarAdapter extends BaseAdapter {
    @Override
    public int getCount() {
        return 14;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.single_view_in_cal, viewGroup, false);
        TextView day = (TextView) view.findViewById(R.id.day_txt);
        day.setTextColor(ContextCompat.getColor(viewGroup.getContext(), android.R.color.white));
        if(position<7){
            day.setText(Constants.DAYS_SHORT[position]);
        }
        else{
            DateTime dateTime = DateUtils.getToday();
            day.setText(String.valueOf(dateTime.getDayOfMonth() - dateTime.getDayOfWeek()+position-6));
            if(dateTime.getDayOfMonth() == Integer.parseInt(day.getText().toString())){
                day.setBackgroundResource(R.drawable.main_circle_bg);
                day.setTextColor(ContextCompat.getColor(viewGroup.getContext(), R.color.gradientEndColor));
            }
        }

        return view;
    }
}
