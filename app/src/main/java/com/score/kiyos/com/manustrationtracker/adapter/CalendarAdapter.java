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

/**
 * Created by Kiyos on 3/21/2017.
 */

public class CalendarAdapter extends BaseAdapter{


    int month;

    public CalendarAdapter(int month) {
        this.month = DateUtils.getFirstDayOfMonth(month);
    }

    @Override
    public int getCount() {
        return 36 +  month;
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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_view_in_cal,parent,false);

        TextView day = (TextView) view.findViewById(R.id.day_txt);

        if(position < 7){
            day.setText(Constants.DAYS_SHORT[position]);
        }

        if(position - 6 >= month){

                if(DateUtils.getDate() == position - 5 - month){
                    day.setTextColor(ContextCompat.getColor(parent.getContext(), R.color.gradientEndColor));
                    day.setBackgroundResource(R.drawable.today_bg);
                }
                else{
                    day.setBackgroundResource(android.R.color.transparent);
                    day.setTextColor(ContextCompat.getColor(parent.getContext(), android.R.color.white));
                }
                day.setText(position - 5 - month+"");
        }

        return view;
    }
}
